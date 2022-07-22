package br.com.cwi.nespresso_app.data.network.mapper

import br.com.cwi.nespresso_app.data.network.entity.CharacterResponse
import br.com.cwi.nespresso_app.domain.entity.Champion

fun CharacterResponse.toChampion() = Champion (
    id, key, name, title, blurb, attack, defense, magic, difficulty, image_icon, image_loading, image_splash, tags
)

fun List<CharacterResponse>.toListChampion() = this.map { it.toChampion() }

