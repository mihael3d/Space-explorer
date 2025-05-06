package kz.mihael3d.spaceexplorer.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kz.mihael3d.spaceexplorer.core.nasaApi.models.ApodItem
import kz.mihael3d.spaceexplorer.core.nasaApi.provideApodApi

open class ApodViewModel: ViewModel() {

    private val api = provideApodApi()
    private val _photo = MutableStateFlow<ApodItem?>(null)
    open val photo : StateFlow<ApodItem?> = _photo

    init {
        loadTodayPhoto()

    }

    fun loadTodayPhoto(){
        viewModelScope.launch {
            try {
                _photo.value = api.getApod()
                val rawJson = api.getApod()
                Log.d("APOD_RESULT", "Response: $rawJson")
            } catch (e: Exception) {
                // TODO добавить обработку ошибок
                _photo.value = null
                Log.d("mihael_net_error",e.message.toString())
            }

        }
    }
}