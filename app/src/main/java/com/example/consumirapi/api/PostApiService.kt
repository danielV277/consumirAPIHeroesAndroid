package com.example.consumirapi.api
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApiService {
    @GET("all.json")
    suspend fun getHeroesPost():ArrayList<SuperHeroe>
    //suspend fun getBiografiaPost():ArrayList<Biography>
    //suspend fun getImagenesPost():ArrayList<Images>
    @GET("https://akabab.github.io/superhero-api/api/powerstats/{heroeId}.json")
    suspend fun getHeroeId(@Path("heroeId") heroeId:String):PoderesHeroe
}