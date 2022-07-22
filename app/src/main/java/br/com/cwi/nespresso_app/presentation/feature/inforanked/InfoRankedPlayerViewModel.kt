package br.com.cwi.nespresso_app.presentation.feature.inforanked

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.cwi.nespresso_app.domain.entity.Champion
import br.com.cwi.nespresso_app.domain.entity.InfoPlayer
import br.com.cwi.nespresso_app.domain.repository.ChampionRepository
import br.com.cwi.nespresso_app.domain.repository.InfoRankedRepository
import br.com.cwi.nespresso_app.presentation.base.BaseViewModel

class InfoRankedPlayerViewModel(private val repository: InfoRankedRepository) : BaseViewModel() {

    private val _player: MutableLiveData<InfoPlayer> = MutableLiveData()
    val player: LiveData<InfoPlayer> = _player


    fun fetchInfoPlayer(id: String) {
        launch {
            _player.postValue(repository.getInfoPlayer(id))
        }
    }



}