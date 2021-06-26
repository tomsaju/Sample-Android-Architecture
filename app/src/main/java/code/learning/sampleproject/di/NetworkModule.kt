package code.learning.sampleproject.di

import code.learning.sampleproject.BuildConfig
import code.learning.sampleproject.network.ApiHelper
import code.learning.sampleproject.network.ApiHelperImpl
import code.learning.sampleproject.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient() = if(BuildConfig.DEBUG){
        OkHttpClient.Builder()
            .addInterceptor(getLoggingInterceptor())
            .build()
    }else{
        OkHttpClient.Builder().build()
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
    Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper


    fun getLoggingInterceptor():HttpLoggingInterceptor {
        var interceptor = HttpLoggingInterceptor {
                message -> Timber.tag("OkHttp").d(message)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY;

        return interceptor
    }

}