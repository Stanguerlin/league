package br.com.cwi.nespresso_app.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    private val _error = MutableLiveData<Exception>()
    val exception: LiveData<Exception> = _error

    fun launch( block: suspend () -> Unit) {

        viewModelScope.launch {
            try {
                block()
            } catch (ex: Exception) {
                _error.postValue(ex)
            }

        }
    }
}