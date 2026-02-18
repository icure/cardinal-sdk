import { McpServer } from "@modelcontextprotocol/sdk/server/mcp.js";
import { z } from "zod";
import { randomUUID } from "node:crypto";

export interface PaginatedListIterator<T> {
	hasNext(): Promise<boolean>;
	next(limit: number): Promise<Array<T>>;
}

const iteratorStore = new Map<string, { iterator: PaginatedListIterator<unknown>; createdAt: number }>();

const ITERATOR_TTL_MS = 10 * 60 * 1000; // 10 minutes

export function storeIterator(iterator: PaginatedListIterator<unknown>): string {
	const id = randomUUID();
	iteratorStore.set(id, { iterator, createdAt: Date.now() });
	cleanupExpired();
	return id;
}

function cleanupExpired() {
	const now = Date.now();
	for (const [id, entry] of iteratorStore) {
		if (now - entry.createdAt > ITERATOR_TTL_MS) {
			iteratorStore.delete(id);
		}
	}
}

export async function collectFirstPage<T>(
	iterator: PaginatedListIterator<T>,
	pageSize = 100
): Promise<{ items: T[]; hasMore: boolean; iteratorId?: string }> {
	const items = await iterator.next(pageSize);
	const hasMore = await iterator.hasNext();

	if (hasMore) {
		const iteratorId = storeIterator(iterator as PaginatedListIterator<unknown>);
		return { items, hasMore: true, iteratorId };
	}

	return { items, hasMore: false };
}

export function registerContinueIterationTool(server: McpServer) {
	server.tool(
		"cardinal_continue_iteration",
		"Fetch the next page of results from a paginated query. Use the iteratorId returned by a previous call.",
		{
			iteratorId: z.string().describe("The iterator ID from a previous paginated response"),
			pageSize: z.number().optional().default(100).describe("Number of items to fetch (default 100)"),
		},
		async ({ iteratorId, pageSize }) => {
			const entry = iteratorStore.get(iteratorId);
			if (!entry) {
				return {
					content: [{
						type: "text" as const,
						text: JSON.stringify({ error: "Iterator not found or expired. Start a new query." }),
					}],
					isError: true,
				};
			}

			const items = await entry.iterator.next(pageSize);
			const hasMore = await entry.iterator.hasNext();

			if (!hasMore) {
				iteratorStore.delete(iteratorId);
			}

			return {
				content: [{
					type: "text" as const,
					text: JSON.stringify({ items, hasMore, iteratorId: hasMore ? iteratorId : undefined }, null, 2),
				}],
			};
		}
	);
}
