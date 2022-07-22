package br.com.cwi.nespresso_app.data.network.remote

import br.com.cwi.nespresso_app.data.network.entity.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface LeagueApi {

    @GET("/personagens")
    suspend fun getCharacter(): List<CharacterResponse>

    @GET("/personagens/{id}")
    suspend fun getCharacterDetail(
        @Path("id") id: String
    ): CharacterResponse

}