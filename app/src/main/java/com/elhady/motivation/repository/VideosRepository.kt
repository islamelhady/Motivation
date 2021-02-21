package com.elhady.motivation.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.elhady.motivation.database.VideosDatabase
import com.elhady.motivation.database.asDomainModel
import com.elhady.motivation.domain.DevByteVideo
import com.elhady.motivation.network.DevByteNetwork
import com.elhady.motivation.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * Created by islam elhady on 16-Feb-21.
 */
class VideosRepository (private val database: VideosDatabase){

    val videos: LiveData<List<DevByteVideo>> = Transformations.map(database.videoDao.getVideos()){
        it.asDomainModel()
    }

    suspend fun refreshVideos(){
        withContext(Dispatchers.IO){
            Timber.d("refresh videos is called")
            val playlist = DevByteNetwork.devbytes.getPlaylist()
            database.videoDao.insertAll(playlist.asDatabaseModel())
        }

    }
}