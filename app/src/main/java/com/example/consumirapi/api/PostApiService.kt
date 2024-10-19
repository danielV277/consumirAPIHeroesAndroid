package com.example.consumirapi.api
import retrofit2.http.GET
interface PostApiService {
    @GET("all.json")
    suspend fun getHeroesPost():ArrayList<SuperHeroe>
    //suspend fun getBiografiaPost():ArrayList<Biography>
    //suspend fun getImagenesPost():ArrayList<Images>
}