package kz.mihael3d.spaceexplorer.core.nasaApi

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kz.mihael3d.spaceexplorer.core.nasaApi.models.ApodItem
import retrofit2.http.GET
import retrofit2.http.Query
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * [API Documentation](https://api.nasa.gov/)  Astronomy Picture of the Day.
 */


interface ApodApi{
    /**
    https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date
     */

    @GET("planetary/apod")
    suspend fun getApod(
        @Query("api_key") apiKey: String = "4I4EmbNgFhIkyyhiF4U1ILyeHfeSOm4Vqs941EbD"
    ): ApodItem


}

fun provideApodApi(): ApodApi {
    val contentType = "application/json".toMediaType()
//    val json = Json { ignoreUnknownKeys = true }

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/")
        .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory(contentType))
        .build()

    return retrofit.create(ApodApi::class.java)
}


