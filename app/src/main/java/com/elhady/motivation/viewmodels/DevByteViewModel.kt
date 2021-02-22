package com.elhady.motivation.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.elhady.motivation.database.getDatabase
import com.elhady.motivation.repository.VideosRepository
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * Created by islam elhady on 16-Feb-21.
 */
class DevByteViewModel(application: Application) : AndroidViewModel(application) {

    private val videosRepository = VideosRepository(getDatabase(application))
    /**
     * A playlist of videos displayed on the screen.
     */
    val playlist = videosRepository.videos

    /**
     * Event triggered for network error. This is private to avoid exposing a
     * way to set this value to observers.
     */
    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    /**
     * Event triggered for network error. Views should use this to get access
     * to the data.
     */
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    /**
     * Flag to display the error message. This is private to avoid exposing a
     * way to set this value to observers.
     */
    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    /**
     * Flag to display the error message. Views should use this to get access
     * to the data.
     */
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    /**
     * init{} is called immediately when this ViewModel is created.
     */
    init {
        refreshDataFromRepository()
    }

    /**
     * Refresh data from the repository. Use a coroutine launch to run in a
     * background thread.
     */
    private fun refreshDataFromRepository(){
        viewModelScope.launch {
            try {
                videosRepository.refreshVideos()
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false
            } catch (networkError: IOException){
                // Show a Toast error message and hide the progress bar.
                if(playlist.value.isNullOrEmpty())
                    _eventNetworkError.value = true
            }
        }
    }
}