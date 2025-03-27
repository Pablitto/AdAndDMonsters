package ru.pk.repository.api

import ResponseMonsters
import ru.pk.repository.api.model.MonsterFull
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Api {

    companion object{
        const val BASE_URL = "https://www.dnd5eapi.co"
    }

    @Headers("Accept: application/json")
    @GET("api/2014/monsters")
    suspend fun getMonstersList(): ResponseMonsters

    @Headers("Accept: application/json")
    @GET("api/2014/monsters/{index}")
    suspend fun getMonster(
        @Path("index") index: String
    ): MonsterFull
}