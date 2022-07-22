package br.com.cwi.nespresso_app.domain.repository

import br.com.cwi.nespresso_app.domain.entity.InfoPlayer
import br.com.cwi.nespresso_app.domain.entity.InfoRanked

interface InfoRankedRepository {

    suspend fun getInfoPlayer(nick: String): InfoPlayer
    suspend fun getInfoRanked(id: String): InfoRanked

}