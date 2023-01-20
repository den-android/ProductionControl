package net.denis.productioncontrol.core.di.module

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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