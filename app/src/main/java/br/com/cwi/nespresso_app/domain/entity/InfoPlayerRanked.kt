package br.com.cwi.nespresso_app.domain.entity

class InfoPlayerRanked(
    var id: String,
    var name: String,
    var profileIconId: Int,
    var summonerLevel: Int,
    var tier: String,
    var rank: String,
    var leaguePoints: Int,
    var wins: Int,
    var losses: Int,
)