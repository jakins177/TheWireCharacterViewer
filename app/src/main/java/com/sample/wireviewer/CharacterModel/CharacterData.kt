package com.sample.wireviewer.CharacterModel

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@kotlinx.parcelize.Parcelize
data class CharacterData(

    @Json(name = "RelatedTopics")
    val RelatedTopics: List<RelatedTopic>,
) : Parcelable