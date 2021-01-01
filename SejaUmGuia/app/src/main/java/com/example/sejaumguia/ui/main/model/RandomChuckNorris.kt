package com.example.sejaumguia.ui.main.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.google.gson.annotations.SerializedName


data class RandomChuckNorris(@SerializedName ("categories") val categories:ArrayList<String>?= null,
                             @SerializedName ("created_at") val created_at:String? = null,
                             @SerializedName ("icon_url") val icon_url:String?= null,
                             @SerializedName ("id") val id:String?= null,
                             @SerializedName ("updated_at") val updated_at:String?= null,
                             @SerializedName ("value") val value:String?= null,
                             @SerializedName ("url") val url:String?= null)