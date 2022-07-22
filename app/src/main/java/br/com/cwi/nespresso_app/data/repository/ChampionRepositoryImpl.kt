package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.network.remote.LeagueApi
import br.com.cwi.nespresso_app.data.network.mapper.toChampion
import br.com.cwi.nespresso_app.data.network.mapper.toListChampion
import br.com.cwi.nespresso_app.domain.entity.Champion
import br.com.cwi.nespresso_app.domain.repository.ChampionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChampionRepositoryImpl(private val api: LeagueApi):ChampionRepository  {

    override suspend fun getCharacters(): List<Champion> {
        return withContext(Dispatchers.IO) {
            api.getCharacter().toListChampion()
        }
    }

    override suspend fun getCharacterDetail(id: String): Champion {
        return withContext(Dispatchers.IO) {
            api.getCharacterDetail(id).toChampion()
        }
    }

}