package br.com.cwi.nespresso_app.presentation.feature.championdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.domain.entity.Champion
import br.com.cwi.nespresso_app.domain.repository.ChampionRepository
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel

class ChampionDetailViewModel(private val repository: ChampionRepository) : BaseViewModel() {

    private val _data: MutableLiveData<Champion> = MutableLiveData()
    val data: LiveData<Champion> = _data

    fun fetchCharacter(id: String) {
        launch {
            _data.postValue(repository.getCharacterDetail(id))
        }
    }



}