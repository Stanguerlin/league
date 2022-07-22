package br.com.cwi.nespresso_app.data.repository

import br.com.cwi.nespresso_app.data.network.remote.RankedApi
import br.com.cwi.nespresso_app.data.network.mapper.toInfoPlayer
import br.com.cwi.nespresso_app.data.network.mapper.toInfoRanked
import br.com.cwi.nespresso_app.domain.entity.InfoPlayer
import br.com.cwi.nespresso_app.domain.entity.InfoRanked
import br.com.cwi.nespresso_app.domain.repository.InfoRankedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InfoRankedRepositoryImpl(private val api: RankedApi):InfoRankedRepository  {

    override suspend fun getInfoPlayer(nick: String): InfoPlayer {
        return withContext(Dispatchers.IO) {
            api.getInfoPlayer(nick).toInfoPlayer()
        }
    }

    override suspend fun getInfoRanked(id: String): InfoRanked {
        return withContext(Dispatchers.IO) {
            api.getInfoRanked(id).toInfoRanked()
        }
    }



}