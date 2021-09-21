package com.example.carcamping.api.response

data class SearchListResponse(
    val response: SearchResponse
)

data class SearchResponse(
    val body: SearchBody,
    val header: Header
)

data class SearchBody(
    val items: SearchItems,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)


data class SearchItems(
    val item: List<SearchItem>
)

data class SearchItem(
    val addr1: String,
    val addr2: String,
    val allar: Int,
    val animalCmgCl: String,
    val autoSiteCo: Int,
    val bizrno: String,
    val brazierCl: String,
    val caravAcmpnyAt: String,
    val caravSiteCo: Int,
    val clturEvent: String,
    val clturEventAt: String,
    val contentId: Int,
    val createdtime: String,
    val doNm: String,
    val eqpmnLendCl: String,
    val exprnProgrm: String,
    val exprnProgrmAt: String,
    val extshrCo: Int,
    val facltDivNm: String,
    val facltNm: String,
    val featureNm: String,
    val fireSensorCo: Int,
    val firstImageUrl: String,
    val frprvtSandCo: Int,
    val frprvtWrppCo: Int,
    val glampInnerFclty: String,
    val glampSiteCo: Int,
    val gnrlSiteCo: Int,
    val homepage: String,
    val induty: String,
    val indvdlCaravSiteCo: Int,
    val insrncAt: String,
    val intro: String,
    val lctCl: String,
    val lineIntro: String,
    val manageNmpr: Int,
    val manageSttus: String,
    val mangeDivNm: String,
    val mapX: Double,
    val mapY: Double,
    val modifiedtime: String,
    val operDeCl: String,
    val operPdCl: String,
    val posblFcltyCl: String,
    val prmisnDe: String,
    val resveCl: String,
    val resveUrl: String,
    val sbrsCl: String,
    val sbrsEtc: String,
    val sigunguNm: String,
    val siteBottomCl1: Int,
    val siteBottomCl2: Int,
    val siteBottomCl3: Int,
    val siteBottomCl4: Int,
    val siteBottomCl5: Int,
    val siteMg1Co: Int,
    val siteMg1Vrticl: Int,
    val siteMg1Width: Int,
    val siteMg2Co: Int,
    val siteMg2Vrticl: Int,
    val siteMg2Width: Int,
    val siteMg3Co: Int,
    val siteMg3Vrticl: Int,
    val siteMg3Width: Int,
    val sitedStnc: Int,
    val swrmCo: Int,
    val tel: String,
    val themaEnvrnCl: String,
    val toiletCo: Int,
    val tourEraCl: String,
    val trlerAcmpnyAt: String,
    val trsagntNo: String,
    val wtrplCo: Int,
    val zipcode: Int
)