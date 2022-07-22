package br.com.cwi.nespresso_app.data.network.remote

import br.com.cwi.nespresso_app.data.network.entity.InfoPlayerResponse
import br.com.cwi.nespresso_app.data.network.entity.InfoRankedResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface RankedApi {

    @Headers("X-Riot-Token: RGAPI-208b2fe2-2e9d-46a7-876e-ee769a5a0b5d")
    @GET("/lol/summoner/v4/summoners/by-name/{nick}")
    suspend fun getInfoPlayer(
        @Path("nick") nick: String
    ): InfoPlayerResponse

    @Headers("X-Riot-Token: RGAPI-208b2fe2-2e9d-46a7-876e-ee769a5a0b5d")
    @GET("/league/v4/entries/by-summoner/{id}")
    suspend fun getInfoRanked(
        @Path("id") id: String
    ): InfoRankedResponse

}