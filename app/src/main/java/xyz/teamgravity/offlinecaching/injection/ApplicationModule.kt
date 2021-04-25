package xyz.teamgravity.offlinecaching.injection

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.teamgravity.offlinecaching.arch.api.RandomDataApi
import xyz.teamgravity.offlinecaching.arch.repository.MainRepository
import xyz.teamgravity.offlinecaching.arch.repository.MainRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideRandomDataApi(): RandomDataApi =
        Retrofit.Builder()
            .baseUrl(RandomDataApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RandomDataApi::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(api: RandomDataApi): MainRepository = MainRepositoryImpl(api)
}