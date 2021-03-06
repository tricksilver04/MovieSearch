package com.example.challenge.api.omdb.service

import com.example.challenge.api.omdb.dto.Movie
import com.example.challenge.api.omdb.dto.MovieSearchResult
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbApiService {

    @GET("/")
    suspend fun getMovieList(
        @Query("s") searchTerm: String,
        @Query("page") page: Int,
        @Query("apikey") apikey: String
    ): Response<MovieSearchResult>

    @GET("/")
    suspend fun getMovieItem(
        @Query("i") omdbId: String,
        @Query("apikey") apikey: String
    ): Response<Movie>
}