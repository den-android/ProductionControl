package net.denis.productioncontrol.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.productioncontrol.data.remote.AssemblyStageApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

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
//    fun provideAssemblyStageApi(gson: Gson, httpClient: OkHttpClient): AssemblyStageApi {
//        return Retrofit.Builder()
//            .baseUrl("")
//            .client(httpClient)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//            .create(AssemblyStageApi::class.java)
//    }
}