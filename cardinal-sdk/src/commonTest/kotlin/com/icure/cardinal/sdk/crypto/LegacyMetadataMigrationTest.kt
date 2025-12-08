@file:OptIn(InternalIcureApi::class)

package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.testGroupAdminAuth
import com.icure.cardinal.sdk.test.testGroupId
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.hexToByteArray
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec

private data class TestData(
	val p: DataOwnerDetails,
	val a: DataOwnerDetails,
	val b: DataOwnerDetails,
	val patientId: String,
	val patientConfidentialSecretId: String,
	val patientNote: String
)

// The following data was created for test purposes only and does not contain any real key / secrets.
@InternalIcureApi
private suspend fun createTestDataAndApis(): TestData {
	val pId = defaultCryptoService.strongRandom.randomUUID().toString()
	val pLogin = "parent-${defaultCryptoService.strongRandom.randomUUID()}"
	val pPassword = defaultCryptoService.strongRandom.randomUUID().toString()
	val pPrivateKey =
		"308204be020100300d06092a864886f70d0101010500048204a8308204a40201000282010100b8f7e992be3973d42954ca27da89259961c93cca31c6494b074f6f5992ce7ba1d95fdfaf043d5047b6e492c735d68344e0348f08683f1dae728d1e86c439c8498613ec7c8fb54930afbb9f45c74f4d312ecf5d989cb2edd96f887551792094ddd2d18a4c2dc2107c9b044b755f93f8d63e956e1ff0299fa9ed190845f7f5f69dc510df005bd929fb4fed33b30d6e699e0632485cc4180cf5a130357cf64233a680a1a1cc6b6761188192734916cabda14bb954ba3807b84c92f078fe83eea31260390356a8d53853148191144a4584fef02d28bc8353d3c33a87b156396e5fcb7994165da48138db3a3b986fe1c12d46273a218af63b42514690fbb161a5179d0203010001028201000e18c171b03dab58dd5830eff34a7080780b60d952b721eed8927292090b8e308f8dd6fba7a9b9ec929668f94b091b880198ffd84c2eede6d5a41ba779b24da9622687e76bac629f95efb3fbc56cd87289cc13fe058892c7f77ac18b815d1250b58dc7ff20f2f6a95dc7135926a79daca0fdbd1ed756d4c19be8447bd0a200e17419cdd90af54e3b204c1297054d61a6ba9183dfd280d571ee52ee3ed39959abb36ecf575429727d8130bfb070131a46b473a94798834707431bdd248e873d9a716cc469d7f21b545dc2eb21d892e8d94ee6544bd82e8112e697eeaecf6a01d31bffaaf37558aec381f8d12c8491ff77ce00a1da4e2fe6ddf4e5dd14fe1ef90102818100dd2b49e13111593e91a882ae522c1363e2b5e3a10e71c4599e32eec56d9d01682983232b582f2e0923dd107e259771382dd7ff738be31cbba5095153a636dd44e8b08f47e044bbf5814aebdcfed33f0a32fc2f62bf3a0ded9d8aed48fc8034debbf5399862ca2bac72d9d4ab70f90a6a246c6cf4a62c9cb887ea776dce57511902818100d61925b811da57c10e444528230bdb0156516b5ca9ff89a9e57da8373bf5911d009bf5e8a6ee0d40edb89f01e638a528ce592e27d3e7f2172ce373a3b510f2f5045a5dd9aa4ae28b088553a5d099f95611447df464da04168d88ba69751046229131b5a820f9215548de643a82a04ad062ddd74a2e2f30d88480b115c2aa372502818031e374dbce14aabbd9615870f7ea27498db717ac99b481e4f1316df8acbc10b82d3cfe6ee58a66e8fae4ffb664c65f6c9bb2b055a1054ed2e8ec4c23014838eb354db654313b6fe6760eaf5b7f43a961a4948c1fcb20ce497e12fb694e43a12968de6cea79c63ec9bc72746d63a3597d0dd04357803069fd99f302938b4ad8e902818100c167f835ff12b2417924dd2074006ab81b84f3aac2fb501e056d6d3f704fd6e64f3d9478b60bc83746488883cbb8922279be003f0463bcc388ce741188292681868c27c9d0d7532d6be61d7966272221c8f9899af45c2a63413a29c3c8778a1401fbd8f167d00677a79b1709f024e350ba6f52e3f532b63a72005b789fe0ea6d02818100cd0855c641e6294a1c05667f043eedf539c38bbd357dd20dacb182c96455593c689eafc7844d2ba8cd86ce77a3f3151aa261434cdb4d21367c9c62f73289aecb2719de0aca9857365eb16cc56bffbd9b28835eaa4499971996e63306bfdfea35c86179bd749992501aa6c0f45c0123ef6a8a3bb4344c198a0046b94c3bf506f5"
	val pPublicKey =
		"30820122300d06092a864886f70d01010105000382010f003082010a0282010100b8f7e992be3973d42954ca27da89259961c93cca31c6494b074f6f5992ce7ba1d95fdfaf043d5047b6e492c735d68344e0348f08683f1dae728d1e86c439c8498613ec7c8fb54930afbb9f45c74f4d312ecf5d989cb2edd96f887551792094ddd2d18a4c2dc2107c9b044b755f93f8d63e956e1ff0299fa9ed190845f7f5f69dc510df005bd929fb4fed33b30d6e699e0632485cc4180cf5a130357cf64233a680a1a1cc6b6761188192734916cabda14bb954ba3807b84c92f078fe83eea31260390356a8d53853148191144a4584fef02d28bc8353d3c33a87b156396e5fcb7994165da48138db3a3b986fe1c12d46273a218af63b42514690fbb161a5179d0203010001"
	val pHcpBase: HealthcareParty = Serialization.json.decodeFromString("""{
		"id": "$pId",
		"lastName": "8ed642",
		"firstName": "c9d727",
		"publicKey": "$pPublicKey"
	}""")
	val pUserBase: User = Serialization.json.decodeFromString("""{
		"id": "${defaultCryptoService.strongRandom.randomUUID()}",
		"name": "$pLogin",
		"status": "ACTIVE",
		"login": "$pLogin",
		"passwordHash": "$pPassword",
		"healthcarePartyId": "$pId",
		"email": "${DataOwnerDetails.testEmailForLogin(pLogin)}"
	}""")
	val aId = defaultCryptoService.strongRandom.randomUUID().toString()
	val aLogin = "childA-${defaultCryptoService.strongRandom.randomUUID()}"
	val aPassword = defaultCryptoService.strongRandom.randomUUID().toString()
	val aPrivateKey =
		"308204bd020100300d06092a864886f70d0101010500048204a7308204a30201000282010100e92f6acc40dbf839fa26e14579fcb68b5e8530f7bfada96338d4f986936cf177e242a458cb1811c2c49c469fa84d2c6ba0c0f34ba6e28babfaff863ff9f3938741d4a41b936143adcff5b396ce12f253e1af424ebd75aa133bdf606b1be51142ee4f5310f4ab46b7a7d706034028f81c462a758f0243d3791d27758bcc8af8010116ee70f1e61eb4526d05d245d631459974eea86b500ad0083e7f196ab9c4926487d92aa2849878f2e4093691d0539b9e880ff6717dbe5e7903141aaf796d74100c42c4d33ac2356df7e3e037accf4495c05f2caf57ae47130b1833f95397e1e9324f2abc1e6af56d7297cf48ea2ba0d990cff2f3b59b1e44efebd4db537ced020301000102820100129e03bed566d42be33a2ea48dcabfd37cc004c13c98e3af3beb8eaee9ebed2d0f2316f667e3d8772b35c3b8eab9cea0e795f356c81d63dd5edacbd325646d7a837367220149e71a97751c73857609ca1cabdea898509508cb49beb88e7c63099ef79bf36302381dfa6e833f2e6496fa8e1df81c04db7971a335d87f7c7660ba6ffb6cc0b3089086df855145b69dba0404ae77b1d533693030e8aa17b851c313d9de7b98a2cd5333fbd1b7d9d7d8d4296c2fc794a50003438eccf0d6dc0a0b34c2695d4f40fa8a5d2de12d5579bc3b33208227cff350413702643f31e0d02317da8165c3f7f1b6a18f00fcea5d981904cb1f5c2bd85d30da963184611f0a06d902818100f6860c1d1c53ad2489bc5e967365e226b25bf292c9ca4f01bbee6d7665f544834f553275e6dc373ed69c942d2e889be2537ae5f5672988c63993bc4f95cbb3dc25b3b8cdf7e274b61532b0e101df22cd54735c2d3f353a4d2d48a1e8dcf11089545b3d8b37f4fa2d3d91129d92e67d9937b065a0bf07c7801df87dd8c1c95f4702818100f2261c810d62345f806345b909e8b1d399d961d5f1bd3c580c96c44ba2e6e532ac93f12cdb25fb6fa9e7a823052c2983611b6c359df98be6c7d0e6377a27cd7f0f67f4568fb72c42d7c3bb13afead3b25a30b7827c1f059d9f75c939fc8608afe2882fdeeb3c292ba45647f373c8ff5719c6da1152c94871b722e8129851a42b028181008fe65945d8d6233833ca27f06c75e957ab3f2ece6e49d06a73b7ce5f914e64eabd313f1e415f044482e3ad3ede6dd188803039f15081971c1659dd4f1b62679fb6c63cb6c5de834012099fe407c2a73ef1efd0bb7cace6564c7b9c3f2050fad51ecf8f92275cb1781cfb04c1c41114f98ddf42c35d1efe5e13a08c5d2d690d5b02818033d7a2fca22fe744970929f13ec4d9e592a7aec18e3ad483895671fa3b8b3180d2dfed9f8bdfaae032410d8749e1359612213bde92cecd7c0045a234386bf31c03e15eb7759762db80b440062c009b8830b50364e54c02f8c71e0191ef9586a099604cd76e07784d06a70e4a79fc8b664b777e527d25e8e3a7b0ca7cc8ad99f70281803b9df4b2e66d849b269300fe42c3136d929fdc184d51283a9fe25772a796ed710b475e85a4e442519a207eeb66e0d89d552798a9b2eb2ebb329109cf4fbce35feba75025a157b57c98776dbe9f04c8937e5cd34021b68ffac95c23c3129967a3aa82ddda35098ba55958e3531fa226825a2685e1ce94353a22a03a1eb9b1a9a0"
	val aPublicKey =
		"30820122300d06092a864886f70d01010105000382010f003082010a0282010100e92f6acc40dbf839fa26e14579fcb68b5e8530f7bfada96338d4f986936cf177e242a458cb1811c2c49c469fa84d2c6ba0c0f34ba6e28babfaff863ff9f3938741d4a41b936143adcff5b396ce12f253e1af424ebd75aa133bdf606b1be51142ee4f5310f4ab46b7a7d706034028f81c462a758f0243d3791d27758bcc8af8010116ee70f1e61eb4526d05d245d631459974eea86b500ad0083e7f196ab9c4926487d92aa2849878f2e4093691d0539b9e880ff6717dbe5e7903141aaf796d74100c42c4d33ac2356df7e3e037accf4495c05f2caf57ae47130b1833f95397e1e9324f2abc1e6af56d7297cf48ea2ba0d990cff2f3b59b1e44efebd4db537ced0203010001"
	val aHcpBase: HealthcareParty = Serialization.json.decodeFromString("""{
      "id": "$aId",
      "lastName": "6144e2",
      "firstName": "6ca3b4",
      "parentId": "$pId",
      "aesExchangeKeys": {
        "$aPublicKey": 
          {
            "$pId": {
              "3b42514690fbb161a5179d0203010001": 
                "4ca457e66519a3f403e089f56f3838a18af16e47029d33ca40eca6a24d1f213809851920b8d159e3879284e5e8d1e0c64be874261d3e0003c43a21ddab9301f8a54161911d3bebe3b1ee6d2a040ec88caa484b6ffd46200bc6eb1a767f309e960f977b9e82d81a0b4961b517e89f24cbc9d0133f955a8d6f792486b1e5dcd9088fe5ecc07b11230b1960013c914041e5de3e9b3c37fa4c2a44dcf2136aae57e000acfe824dacd900bf6be5f6b4f3c41534237a01e14d728065c586dbfd3eeb81ad070218be3e2f70757e9ca5d940afa0b67e02d41e68c1c10935157bc6bd3c06eda95f23c10ca60b649a5ec32903c2a995c0b97fb40cdf454c53621304b0d5b0",
              "b59b1e44efebd4db537ced0203010001":
                "50864963c90cc12704b35ec6cd15ee40a2f4fd4dcb1cf287612346eab4df139008adef1c6d778e35aa7cb58251ff34d6bf1b0faa59d5453c328fa381b175143f41ce66463146b9a02d546cea0065bf62d1ce58e27a8d3bb8bebbb97b76c7e0d7a67b481fdc5082e99aa0521026eb89344b9404da04b0a69988e03724421747e47ab544ed2c55d0424f2837e641f9df4f4ece731e38f9a16d056d9fcf442730c50b3cabcdfbd8241677648639af75198bd30ded0f0fa2db0f8ce80cf86350cef278ce1c7a5426262ceebcc6be5579892d8e066763e216e1592f3f5faa13c561f73400549f5ba2bd618fb308ef99d52cc360ce30988af058caca8c23113933f588"
            },
            "$aId": {
              "b59b1e44efebd4db537ced0203010001":
                "189ab5f91d1401fe4c8d2be8e044dcb80211fbf1f310d154a21e32b2b7c0cca715178b42a9a5bbd136b81eed1158da5c8e600e265b38c2b608127b343f0d8da301d80eb24a620ed64bec091771a092a2072a922c2852de55942cc99ae0f9c609150c9621cbaf27740105b28e33668ad0a960c13f884029bb1c8253d646b503ac597f8dbb6ce79b64e7b3929b3a3b649805fb327c2d855f47947e8d5dbf9aa4a0da56b9c1030e9fb1f415d0ee48d91d11c320d1bcba9b96a50574ab406f84629edbb86c68ca548d9dcdd08b4d63c93b3d654e810baaf0782068bc91934fb19f9ab46d940dd3d3e27fc6ac1bcd47440f098d97a9b454df929ba60ae0aa5efe7861"
            }
          }
      },
      "publicKey": "$aPublicKey"
    }""")
	val aUserBase: User = Serialization.json.decodeFromString("""{
		"id": "${defaultCryptoService.strongRandom.randomUUID()}",
		"name": "$aLogin",
		"status": "ACTIVE",
		"login": "$aLogin",
		"passwordHash": "$aPassword",
		"healthcarePartyId": "$aId",
		"autoDelegations": {
			"all": ["$pId"]
		},
		"email": "${DataOwnerDetails.testEmailForLogin(aLogin)}"
	}""")
	val bId = defaultCryptoService.strongRandom.randomUUID().toString()
	val bLogin = "childB-${defaultCryptoService.strongRandom.randomUUID()}"
	val bPassword = defaultCryptoService.strongRandom.randomUUID().toString()
	val bPrivateKey =
		"308204bc020100300d06092a864886f70d0101010500048204a6308204a20201000282010100982330dc464b3e9c583affbfece209976bc045f07b22fb44bcb0ebc27bc9d8406b54e380d195e107c1728499a64012b3251c1c85a2516e73b89a07b1929f0c12d44828677135082e8170b9831dd4ff9e988d098731eadd1443813cb5f6af2fe4c2a2706ba6aeb5bb6bb7889be51eebd83bebbb2a0b55a6d69fdeb66894af47edd6f82a8d30629814b82f17cfd1ef75f47d192eb9577c58f14a5e0d2782b13b796b5a3be780a38b0f69f3d00179d13cc23fcec1e919ac05d88c08c693c711384ad9fc7a21ed28d0e5d3865c15db239a5d727d4c52a344975c97379cc5a195ff4f8c1aacbaa67d6d0fd358b6b5d1a4d0575bc57b2d7736108978e3371e9aa0ae8f0203010001028201002a9bac7afc9ae5399f4242cf4b36110e9de8570e1f46704dd374cf4a8425c7115f9e022b59475b23336bf1b4208a1052a8e183217010d358c88a26fe75fc6242c1be45c696bf8dff8c53f838bef9a0ef9774e486bf15b27e12dbd69775b3a1bbb5410e303019fd1eb4efcd6c2fd2a5a5c53e6388466d6210f8ec4474ecb35c76d2c4269d3a585cdce972673c56818015b9f097ff528e26272b76810cb4f8a1ee5ea04ea26f4cf3c6f78b77c5f58d80628f513a4da76cc1e35a6867af1ab76fe0354e549340221d19bfe04783e34f84eca7bd80867134710adc0665a52eb689d2cf6ecb38ca77d84f4feb8c23539e92ac870b3175c174d8f5643aabc0e7ef3cd102818100ba44b38b24e28d9fb85279c0098b4505e0852ba88b54d2cb8b0e77368c1600bb40b4c0f6dee8b97788e082af0f9045dd54f05ee583fffabc473d16272d03c1aef301541176e7a95f948f8d77b6aad087c54f2de713909efdd5d90a8bbec61067172a97480ba844c25cf64a8b1f0698e2f4dd73af798dd8ab329f7f9bf9a0f9ff02818100d11781567bde00a256ac7ef2c4bf10a5b8b2ebab77c941b7665817f17aa496f166ecd89bb4c50c53d4e836b3369edc2f0f49e64f8dbe7ddaf0fb3898075f6e82ab2c69bc925368904ba459ce08a40ce621dceefa78b64d8eb68752d1cc2a53a1db9718ab1a8703333065cf9b8407174c18f8b085e4aebf32a5bf9b259a6bab71028180492352b04f025a039df75c70e80e7442b37ef6be8e3ef72a0ee6d62e67e0f7d68eb8aa9004c4b29659fb75b4d1529fec213ee4b4101981d54dcf91943e5b9c405a9069f7158e2ef625ba1c1d266f79c3e5d88a38927915c4aba4363cdae2a06c2a2f82093af28e5516f56a1da84809de0bb1ac8bf919963ada7cc039795218f70281802b0aceaa31f78263e8b9bbac580a08f04474388564b43e5df5a87ecd4bf4e3c9afe963b1b1e5ba62eb7a1e008866ed66969c1cd81592b82fc0d9c64dad7edcadf374c2137a7fc70fa532a0f603db59786a5223b3d5f399459e977eda0750534507823426cce02c2d76720ee9b1a5100baf3c4a8255900f75ea9ee5de38ca9f510281802c19faaa1e08ac6337c48af1529f8b8685d2582586986b180377aee8cf4eaadcdbb5869c6f994275b0ae3ecc6aa0ead81296ab9a96eecb44f14fcd9e50ef34d9725e97809b3ed2ed6105102c96ea55a096f292a8d9769c05779f303dc6ad3b30c3c9bea749d58636b3977c9c593557c048b2f82e90fead32b5b510966e548e7a"
	val bHcpBase: HealthcareParty = Serialization.json.decodeFromString("""{
		"id": "$bId",
		"lastName": "95ee22",
		"firstName": "2af696",
		"parentId": "$pId",
		"aesExchangeKeys": {
			"30820122300d06092a864886f70d01010105000382010f003082010a0282010100982330dc464b3e9c583affbfece209976bc045f07b22fb44bcb0ebc27bc9d8406b54e380d195e107c1728499a64012b3251c1c85a2516e73b89a07b1929f0c12d44828677135082e8170b9831dd4ff9e988d098731eadd1443813cb5f6af2fe4c2a2706ba6aeb5bb6bb7889be51eebd83bebbb2a0b55a6d69fdeb66894af47edd6f82a8d30629814b82f17cfd1ef75f47d192eb9577c58f14a5e0d2782b13b796b5a3be780a38b0f69f3d00179d13cc23fcec1e919ac05d88c08c693c711384ad9fc7a21ed28d0e5d3865c15db239a5d727d4c52a344975c97379cc5a195ff4f8c1aacbaa67d6d0fd358b6b5d1a4d0575bc57b2d7736108978e3371e9aa0ae8f0203010001":
				{
					"$pId": {
					"3b42514690fbb161a5179d0203010001": 
					"5e186cec6d6ddb277aa5421a345045f5f44aa125844e833529fccfeb3a002dd4aef78d84b5b8710ff0aa375436e2abdea07a2cb186cd914fa8b8fb86ab1201b109d802927b49517322ac6521600a123ee03d9383154b6f0fa0e99a8ca6e73e07ceed4aeb835649a850316c5585b2a69ac6703c7154f2db981913bac36a0cea515c70c505d1dc3a7e3a6db519cf7b68737a80ad102cc575959b08fbe327644e7d1b7da0737bfa6ededdd7bf0538fd3dc040ac57937bebdf3146a566c2619314935bc610e900b9c350fcf21a9b20c47f0ee25112578dc210b6b17c4cad9687d2bd9abab12f03f8b778b74186ac3c61d57058037d0e00903c74d2eaa8b2fdb90e3f", 
					"36108978e3371e9aa0ae8f0203010001": 
					"89764feb4d23d8313d58c0568088ecf9f320dd285eb762eaee8593a9ecc884a54e4eb6cd93a87f1383f345b94b8a7f1d20dda33d972ab4460aef742d44837648403234700a5a9f85032b025c533aebdc7bea07dec17c7a1737a51f873ec36c689a29b3314fa2d0f77d7e83e71e5a1de1392a6e92fb9881d811253f2bc00db0798e213899a85bcf0bafeaf8b972c40b1a0d1dd3109e6a8bc9309caa5ada9bc41ea62c72fbdf7cf49cbbe15cd048e6d614a4d65e09f5bed014975ea19c160e3754abd9031e8a41283fa369fa621685aee16c5a5d18a1811fde27869cb156a00fe28ae42c9ff498f2c3dd88a392ac9d68d9885556effe62850681fa8fbe5e02781f"
				}
			}
		},
		"publicKey":
		"30820122300d06092a864886f70d01010105000382010f003082010a0282010100982330dc464b3e9c583affbfece209976bc045f07b22fb44bcb0ebc27bc9d8406b54e380d195e107c1728499a64012b3251c1c85a2516e73b89a07b1929f0c12d44828677135082e8170b9831dd4ff9e988d098731eadd1443813cb5f6af2fe4c2a2706ba6aeb5bb6bb7889be51eebd83bebbb2a0b55a6d69fdeb66894af47edd6f82a8d30629814b82f17cfd1ef75f47d192eb9577c58f14a5e0d2782b13b796b5a3be780a38b0f69f3d00179d13cc23fcec1e919ac05d88c08c693c711384ad9fc7a21ed28d0e5d3865c15db239a5d727d4c52a344975c97379cc5a195ff4f8c1aacbaa67d6d0fd358b6b5d1a4d0575bc57b2d7736108978e3371e9aa0ae8f0203010001"
	}""")
	val bUserBase: User = Serialization.json.decodeFromString("""{
		"id": "${defaultCryptoService.strongRandom.randomUUID()}",
		"name": "$bLogin",
		"status": "ACTIVE",
		"login": "$bLogin",
		"passwordHash": "$bPassword",
		"healthcarePartyId": "$bId",
		"autoDelegations": {
			"all": ["$pId"]
		},
		"email": "${DataOwnerDetails.testEmailForLogin(bLogin)}"
	}""")
	val patientConfidentialSecretId = "24cd8cf5-0958-4ee9-8e90-95f3d25a47d7"
	val patientBase: EncryptedPatient = Serialization.json.decodeFromString("""{
		"id": "${defaultCryptoService.strongRandom.randomUUID()}",
		"firstName": "John",
		"lastName": "Doe",
		"delegations": {
		"$aId": [
			{
				"owner": "$aId",
				"delegatedTo": "$aId",
				"key": "4bd1316d494e858496f1d6c1200726cb76c7ff98fb47eddb1c0bf5b79712230db3f02bdf60599816e0601628ee349674a0509720e9972d87b2370b60bcbbb19adb2980bc1ab5bab8b9c8adc5516d39d0cf2d6c373fe7285ce0f1018058e52fcc", 
				"tags": ["confidential"]
			},
			{
					"owner": "$aId",
					"delegatedTo": "$aId",
					"key": "6121912dea437ddaf92c41a43deba576976a2b7c10c1cbba79624634ded8bb5d0210db5e339e3e26d33e6e2d18d6b8acc91f8415e5ab488b9227f7c6f6f370873f1d5b5ff3afd28dfe6e47ed10b0cb435676a4db039469a50547f3e1e515fc63"
			}
		],
		"$pId": [
		{
				"owner": "$aId",
				"delegatedTo": "$pId",
				"key": "0b293a861d76b21928c6689fb80c373f16bfbe8269ef201b5af35ff4634e51af1c5d3c535c384efea3126acee3572b815db950c52298b1ee99868041641110100c51ad3bc6d0bafddd5021b50b8e0fd16c44f5fd05617eae4f5a00c090c0ccfb"
		}
		]
	},
		"encryptionKeys": {
		"$aId": [
		{
				"owner": "$aId",
				"delegatedTo": "$aId",
				"key": "42e625cb8930ca763f6b604d08775b4231e9414fa953feeafbd7cfc6acc138bdbf5013aa211935f9f429a627db5d41efa617b2ae9d46f93d83db73b36dab7892c07b03408ee4ab50974b0d4081162b4e9a2a448ce00e35d05aac4d7e675e99b3"
		}
		],
		"$pId": [
		{
				"owner": "$aId",
				"delegatedTo": "$pId",
				"key": "194ee902b4780178fd88ffddd1e0744537ddf952d306dfe1123b14bec4405dc1f6b9aea7444cc74f5acca0d18062c0e12d7d9bb6c7b7bff27efb681c7e5ca52f25797f45207f63c13778637a40a541a2e33d79dc1660d7f898d69c92a93aedcf"
		}
		]
	},
		"encryptedSelf": "jgAFAlmd2QStXpOt3LnIhs4upJv2e10fp0u6/PburW7mq1r3vo/Q5/a4Yk7EWXG7oydMWb2i1UCCiNN80czGdA==" 
	}
	""")
	val userApi = RawUserApiImpl(baseUrl, testGroupAdminAuth(), DefaultRawApiConfig)
	val patientApi = RawPatientApiImpl(baseUrl, testGroupAdminAuth(), null, DefaultRawApiConfig)
	val healthcarePartyApi = RawHealthcarePartyApiImpl(baseUrl, testGroupAdminAuth(), DefaultRawApiConfig)
	healthcarePartyApi.createHealthcareParty(pHcpBase)
	healthcarePartyApi.createHealthcareParty(aHcpBase)
	healthcarePartyApi.createHealthcareParty(bHcpBase)
	userApi.createUser(pUserBase)
	userApi.createUser(aUserBase)
	userApi.createUser(bUserBase)
	patientApi.createPatient(patientBase)
	val keyP = defaultCryptoService.rsa.loadKeyPairPkcs8(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1, hexToByteArray(pPrivateKey))
	val keyA = defaultCryptoService.rsa.loadKeyPairPkcs8(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1, hexToByteArray(aPrivateKey))
	val keyB = defaultCryptoService.rsa.loadKeyPairPkcs8(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1, hexToByteArray(bPrivateKey))
	val pDataOwnerDetails = DataOwnerDetails(
		dataOwnerId = pId,
		username = pLogin,
		password = pPassword,
		keypair = keyP,
		parent = null,
		groupId = testGroupId
	)
	val aDataOwnerDetails = DataOwnerDetails(
		dataOwnerId = aId,
		username = aLogin,
		password = aPassword,
		keypair = keyA,
		parent = pDataOwnerDetails,
		groupId = testGroupId
	)
	val bDataOwnerDetails = DataOwnerDetails(
		dataOwnerId = bId,
		username = bLogin,
		password = bPassword,
		keypair = keyB,
		parent = pDataOwnerDetails,
		groupId = testGroupId
	)
	return TestData(
		p = pDataOwnerDetails,
		a = aDataOwnerDetails,
		b = bDataOwnerDetails,
		patientId = patientBase.id,
		patientConfidentialSecretId = "24cd8cf5-0958-4ee9-8e90-95f3d25a47d7",
		patientNote = "This is just a test patient"
	)
}

class LegacyMetadataMigrationTest : StringSpec({
	"TODO: actually implement this test".config(enabled = DEFAULT_ENABLED) {
		TODO("Adapt the ts test")
	}
})