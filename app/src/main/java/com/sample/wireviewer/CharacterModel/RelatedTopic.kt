package com.sample.wireviewer.CharacterModel

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class RelatedTopic(
    @Json(name = "FirstURL")
    val FirstURL: String,
    @Json(name = "Icon")
    val Icon: Icon,
    @Json(name = "Result")
    val Result: String,
    @Json(name = "Text")
    val Text: String
) : Parcelable