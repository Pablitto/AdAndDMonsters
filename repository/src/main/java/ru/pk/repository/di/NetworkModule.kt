package ru.pk.repository.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.pk.repository.api.Api
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {

    private const val BASE_URL = "https://www.dnd5eapi.co/api/"

    // working
    @Singleton
    @Provides
    fun providesApi(): Api {
        val retrofit =  Retrofit.Builder()
            .client( OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(Api::class.java)
    }

    // not working
//    @Singleton
//    @Provides
//    fun providesApi(retrofit: Retrofit): Api =
//        retrofit.create(Api::class.java)

    // not working
//    @Singleton
//    @Provides
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
//        Retrofit.Builder()
//            .client(
////                OkHttpClient()
////                    .newBuilder()
////                    .connectTimeout(10, TimeUnit.SECONDS)
////                    .readTimeout(10, TimeUnit.SECONDS)
////                    .writeTimeout(10, TimeUnit.SECONDS)
////                    .build()
//                okHttpClient
//            )
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()

    // not working
//    @Provides
//    fun provideHttpClient(): OkHttpClient =
//        OkHttpClient()
//            .newBuilder()
//            .connectTimeout(10, TimeUnit.SECONDS)
//            .readTimeout(10, TimeUnit.SECONDS)
//            .writeTimeout(10, TimeUnit.SECONDS)
//            .build()
}