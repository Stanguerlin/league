package br.com.cwi.nespresso_app.domain.entity

class Champion(
    var id: String,
    var key: Int,
    var name: String,
    var title: String,
    var blurb: String,
    var attack: Int,
    var defense: Int,
    var magic: Int,
    var difficulty: Int,
    var image_icon: String,
    var image_loading: String,
    var image_splash: String,
    var tags: List<String>,
)