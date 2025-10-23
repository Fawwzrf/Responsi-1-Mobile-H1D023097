package com.example.responsi1mobileh1d023097.data.model

import com.google.gson.annotations.SerializedName


data class SearchResponse(
    @SerializedName("name")
    val clubName: String,
    @SerializedName("coach")
    val coach: Coach,
    @SerializedName("squad")
    val squad: List<Player>
)

data class Coach(
    @SerializedName("name")
    val name: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("nationality")
    val nationality: String
    )

data class Player(
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("nationality")
    val nationality: String
): java.io.Serializable