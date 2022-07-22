package br.com.cwi.nespresso_app.presentation.feature.champions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.data.network.entity.CharacterResponse
import br.com.cwi.nespresso_app.domain.entity.Champion
import br.com.cwi.nespresso_app.domain.repository.ChampionRepository
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel

class ChampionViewModel(private val repository: ChampionRepository) : BaseViewModel() {

    private val _characters: MutableLiveData<List<Champion>> = MutableLiveData()
    val characters: LiveData<List<Champion>> = _characters

    fun fetchCharacters() {
        launch {
            val response: List<Champion> =
                repository.getCharacters()

            _characters.postValue(response)
        }
    }

}