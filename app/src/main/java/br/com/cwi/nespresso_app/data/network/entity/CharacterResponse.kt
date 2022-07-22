package br.com.cwi.nespresso_app.data.network.entity

import com.squareup.moshi.Json

class CharacterResponse(

    @Json(name = "id") val id: String,
    @Json(name = "key") val key: Int,
    @Json(name = "name") val name: String,
    @Json(name = "title") val title: String,
    @Json(name = "blurb") val blurb: String,
    @Json(name = "attack") val attack: Int,
    @Json(name = "defense") val defense: Int,
    @Json(name = "magic") val magic: Int,
    @Json(name = "difficulty") val difficulty: Int,
    @Json(name = "image_icon") val image_icon: String,
    @Json(name = "image_loading") val image_loading: String,
    @Json(name = "image_splash") val image_splash: String,
    @Json(name = "tags") val tags: List<String>,

)
