package com.icure.cardinal.sdk.utils.collections

import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class DirectedGraphTest : StringSpec({
	// Online representation of graph https://www.plantuml.com/plantuml/svg/LSux2e8n00FWFQVuHnLw1Ud3jlRHta7GJHsqtby9MPm-I234ljVbjJwFEtQ7_MRCSNDmrCi0JwCyoOAWFjA4H3CoZVACGgkSgBIX_TdHwS3G_bHkRy_hx-4N
	val testGraphEdges = listOf(
		'A' to 'B',
		'A' to 'C',
		'B' to 'D',
		'B' to 'E',
		'B' to 'I',
		'C' to 'C',
		// NO from D,
		'E' to 'F',
		'F' to 'G',
		'G' to 'E',
		'G' to 'H',
		// NO from H,
		'I' to 'J',
		'I' to 'N',
		'J' to 'K',
		'K' to 'K',
		'K' to 'L',
		'L' to 'M',
		'M' to 'I',
		'N' to 'L',
	)

	"Strongly connected graph should match expected".config(enabled = DEFAULT_ENABLED) {
		repeat(100) {
			val graph = testGraphEdges.shuffled().let { edges ->
				DirectedGraph.fromEdges(*edges.toTypedArray())
			}.acyclic()
			val expectedGroups = listOf(
				setOf('A'),
				setOf('B'),
				setOf('C'),
				setOf('D'),
				setOf('E', 'F', 'G'),
				setOf('H'),
				setOf('I', 'J', 'K', 'L', 'M', 'N'),
			)
			graph.acyclicLabelToGroup.values shouldContainExactlyInAnyOrder expectedGroups
			expectedGroups.forEach { group ->
				group.map { graph.originalLabelToAcyclicLabel[it] }.toSet()
					.shouldHaveSize(1).single()
					.shouldNotBeNull()
					.shouldBeIn(group)
			}
			val A = 'A'
			val B = 'B'
			val C = 'C'
			val D = 'D'
			val E = graph.originalLabelToAcyclicLabel.getValue('E')
			val H = 'H'
			val I = graph.originalLabelToAcyclicLabel.getValue('I')
			graph.acyclicGraph.nodesToEdges shouldBe mapOf(
				A to setOf(B, C),
				B to setOf(D, E, I),
				C to emptySet(),
				D to emptySet(),
				E to setOf(H),
				H to emptySet(),
				I to emptySet(),
			)
		}
	}

	"reachSet should match expected".config(enabled = DEFAULT_ENABLED) {
		val graph = DirectedGraph.fromEdges(*testGraphEdges.toTypedArray()).acyclic()
		val A = 'A'
		val B = 'B'
		val C = 'C'
		val D = 'D'
		val E = graph.originalLabelToAcyclicLabel.getValue('E')
		val H = 'H'
		val I = graph.originalLabelToAcyclicLabel.getValue('I')
		graph.reachSets shouldBe mapOf(
			A to setOf(B, C, D, E, H, I),
			B to setOf(D, E, H, I),
			C to emptySet(),
			D to emptySet(),
			E to setOf(H),
			H to emptySet(),
			I to emptySet(),
		)
	}
})