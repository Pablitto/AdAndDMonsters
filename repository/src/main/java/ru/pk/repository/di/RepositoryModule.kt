package ru.pk.repository.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.pk.repository.MonstersRepositoryImpl
import ru.pk.repository.api.Api
import ru.pk.repository.interfaces.MonstersRepository
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
abstract class RepositoryModule {

//    @Singleton
//    @Provides
//    fun provideRepository(api: Api): MonstersRepository =
//        MonstersRepositoryImpl(api)

    @Singleton
    @Binds
    abstract fun bindRepository(repo: MonstersRepositoryImpl): MonstersRepository
}