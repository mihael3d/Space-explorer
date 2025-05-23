package kz.mihael3d.spaceexplorer.core.thespacedevsApi

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json

import kz.mihael3d.spaceexplorer.core.thespacedevsApi.models.LaunchResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit API interface for accessing upcoming rocket launches
 * [API Documentation](https://ll.thespacedevs.com/docs/#/launches/launches_upcoming_list)  upcoming rocket launches.
 */


interface ThespacedevsApi {
    @GET("launches/upcoming/")
    suspend fun getUpcomingLaunches(
        @Query("limit") limit: Int = 3,
        @Query("ordering") ordering: String = "net",
        @Query("format") format: String = "json"
    ): LaunchResponse
}


fun provideThespacedevsApi(): ThespacedevsApi {
    val contentType = "application/json".toMediaType()

    val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Token 2ef4734e3ede6d32a4b2d7e40913039c1950cfab")
                .build()
            chain.proceed(request)
        }
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://ll.thespacedevs.com/2.3.0/")
        .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory(contentType))
        .client(client)
        .build()

    return retrofit.create(ThespacedevsApi::class.java)
}
