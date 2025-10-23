package com.example.responsi1mobileh1d023097.data.network

import com.example.responsi1mobileh1d023097.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballApi {
    @GET("{teamId}")
    suspend fun getTeamDetails(
        @Path("teamId") teamId: Int,
        @Header("X-Auth-Token") apiToken: String
    ): Response<SearchResponse>
}