package br.com.cwi.nespresso_app.data.network.mapper

import br.com.cwi.nespresso_app.data.network.entity.InfoPlayerResponse
import br.com.cwi.nespresso_app.data.network.entity.InfoRankedResponse
import br.com.cwi.nespresso_app.domain.entity.InfoPlayer
import br.com.cwi.nespresso_app.domain.entity.InfoRanked

fun InfoRankedResponse.toInfoRanked() = InfoRanked (
    tier, rank, leaguePoints, wins, losses
)

fun InfoPlayerResponse.toInfoPlayer() = InfoPlayer (
    id, name, profileIconId, summonerLevel
)



