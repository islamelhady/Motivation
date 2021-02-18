package com.elhady.motivation.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elhady.motivation.domain.DevByteVideo

/**
 * Created by islam elhady on 16-Feb-21.
 */
@Entity
data class DatabaseVideo constructor(
        @PrimaryKey
        val url: String,
        val updated: String,
        val title: String,
        val description: String,
        val thumbnail: String)


/**
 * Map DatabaseVideos to domain entities
 * asDomainModel(). Use the function to convert DatabaseVideo database objects into domain objects.
 */
fun List<DatabaseVideo>.asDomainModel(): List<DevByteVideo> {
    return map {
        DevByteVideo(
                url = it.url,
                title = it.title,
                description = it.description,
                updated = it.updated,
                thumbnail = it.thumbnail)
    }
}