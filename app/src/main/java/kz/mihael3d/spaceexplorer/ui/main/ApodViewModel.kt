package kz.mihael3d.spaceexplorer.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kz.mihael3d.spaceexplorer.core.nasaApi.models.ApodItem
import kz.mihael3d.spaceexplorer.core.nasaApi.provideApodApi
import kz.mihael3d.spaceexplorer.core.thespacedevsApi.models.LaunchItem
import kz.mihael3d.spaceexplorer.core.thespacedevsApi.provideThespacedevsApi

 class ApodViewModel: ViewModel() {

    private val apodApi = provideApodApi()
    private val thespacedevsApi = provideThespacedevsApi()


    private val _photo = MutableStateFlow<ApodItem?>(null)
     val photo : StateFlow<ApodItem?> = _photo

    private val _launches = MutableStateFlow<List<LaunchItem>>(emptyList())
     val launches : StateFlow<List<LaunchItem>> = _launches

    init {
        loadTodayPhoto()
        loadUpcomingLaunches()

    }

    private fun loadTodayPhoto() {
        viewModelScope.launch {
            try {
                val result = apodApi.getApod()
                _photo.value = result
                Log.d("APOD_RESULT", "Response: $result")
            } catch (e: Exception) {
                // TODO добавить обработку ошибок
                _photo.value = null
                Log.d("mihael_net_error", e.message.toString())
            }
        }
    }

    private fun loadUpcomingLaunches() {
        viewModelScope.launch{
            try {
                val response = thespacedevsApi.getUpcomingLaunches().results
                _launches.value = response
                Log.d("UPCOMING_LAUNCHES_RESULT", "Response: $response")
            } catch (e: Exception) {
                // TODO добавить обработку ошибок
                _launches.value = emptyList()
                Log.d("mihael_net_error", e.message.toString())
                Log.d("mihael_net_error", "Error loading launches", e)
            }
        }
    }
}