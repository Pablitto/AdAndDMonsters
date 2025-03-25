package ru.pk.repository.api

import ru.pk.repository.api.model.MonsterFull
import ru.pk.repository.api.model.ResponseMonsters
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Api {

    @Headers("Accept: application/json")
    @GET("2014/monsters")
    suspend fun getMonstersList(): ResponseMonsters

    @Headers("Accept: application/json")
    @GET("2014/monsters/{index}")
    suspend fun getMonster(
        @Path("index") index: String
    ): MonsterFull
}