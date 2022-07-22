package br.com.cwi.nespresso_app.data.network.entity

import com.squareup.moshi.Json

class InfoPlayerResponse(

    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "profileIconId") val profileIconId: Int,
    @Json(name = "summonerLevel") val summonerLevel: Int,

)
