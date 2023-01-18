package net.denis.productioncontrol.core.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.features.stage_checklist.data.interfaces.IStageApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
//
//    @Provides
//    @Singleton
//    fun provideGson(): Gson {
//        return GsonBuilder()
//            .setLenient()
//            .create()
//    }
//
//    @Provides
//    @Singleton
//    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
//        HttpLoggingInterceptor.Level.BODY
//        return HttpLoggingInterceptor()
//    }
//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
//        return OkHttpClient()
//            .newBuilder()
//            .addInterceptor(httpLoggingInterceptor)
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideStageApi(gson: Gson, httpClient: OkHttpClient): IStageApi {
//        return Retrofit.Builder()
//            .baseUrl("")
//            .client(httpClient)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//            .create(IStageApi::class.java)
//    }
}