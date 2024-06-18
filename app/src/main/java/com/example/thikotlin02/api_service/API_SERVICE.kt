package com.example.thikotlin02
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

var BASE_URL = "https://666b046d7013419182d1ee62.mockapi.io/"
var gson = GsonBuilder().create()
var SERVICE = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()
    .create<API_SERVICE>(API_SERVICE::class.java)
interface API_SERVICE {
    @GET("comment")
    suspend fun GET_PRODUCT(): List<XeHoi>

    @POST("comment")
    suspend fun ADD_PRODUCT(@Body product: XeHoi): Response<Unit>

    @DELETE("comment/{id}")
    suspend fun DELETE_PRODUCT(@Path("id") id: String): XeHoi
    @PUT("comment/{id}")
    suspend fun UPDATE_PRODUCT(@Path("id") id: String, @Body product: XeHoi): XeHoi

}