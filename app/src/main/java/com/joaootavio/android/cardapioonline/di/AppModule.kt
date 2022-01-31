package com.joaootavio.android.cardapioonline.di

import com.joaootavio.android.cardapioonline.common.Constants.BASE_URL
import com.joaootavio.android.cardapioonline.data.remote.RecipesApi
import com.joaootavio.android.cardapioonline.data.repository.RecipesRepositoryImpl
import com.joaootavio.android.cardapioonline.domain.repository.RecipesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRecipesApi(): RecipesApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipesRepository(api: RecipesApi): RecipesRepository {
        return RecipesRepositoryImpl(api = api)
    }

}