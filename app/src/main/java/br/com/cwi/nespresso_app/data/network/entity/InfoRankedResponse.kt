package br.com.cwi.nespresso_app.data.network.entity

import com.squareup.moshi.Json

class InfoRankedResponse(

    @Json(name = "tier") val tier: String,
    @Json(name = "rank") val rank: String,
    @Json(name = "leaguePoints") val leaguePoints: Int,
    @Json(name = "wins") val wins: Int,
    @Json(name = "losses") val losses: Int,

)
