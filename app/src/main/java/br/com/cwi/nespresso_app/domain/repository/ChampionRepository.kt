package br.com.cwi.nespresso_app.domain.repository

import br.com.cwi.nespresso_app.domain.entity.Champion

interface ChampionRepository {

    suspend fun getCharacters(): List<Champion>
    suspend fun getCharacterDetail(id: String): Champion


}