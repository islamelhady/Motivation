package com.elhady.motivation.domain

import com.elhady.motivation.util.smartTruncate

/**
 * Created by islam elhady on 16-Feb-21.
 */
data class DevByteVideo(val title: String,
                        val description: String,
                        val url: String,
                        val updated: String,
                        val thumbnail: String) {

    /**
     * Short description is used for displaying truncated descriptions in the UI
     */
    val shortDescription: String
        get() = description.smartTruncate(200)
}