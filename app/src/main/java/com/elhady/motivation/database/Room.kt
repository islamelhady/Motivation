package com.elhady.motivation.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.*
import androidx.room.Query

/**
 * Created by islam elhady on 16-Feb-21.
 */
@Dao
interface VideoDao {

    @Query("select * from databasevideo")
    fun getVideos(): LiveData<List<DatabaseVideo>>

    @Insert(onConflict = REPLACE)
    fun insertAll( videos: List<DatabaseVideo>)
}