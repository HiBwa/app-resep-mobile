package com.fikri.resepmasakan.api


import com.fikri.resepmasakan.model.ResponModel
import com.fikri.resepmasakan.model.ResponUser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("no_hp") nomortlp: String,
        @Field("password") password: String,
    ): Call<ResponModel>


    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ): Call<ResponModel>


    @FormUrlEncoded
    @POST("logout")
    fun logout(
    @Header("token") token: String
    ): Call<ResponModel>


    @GET("user")
    fun user(
        @Header("token") token: String
    ): Call<ArrayList<ResponUser>>


}