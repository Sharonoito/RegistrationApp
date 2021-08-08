package com.example.registration.api

import com.example.registration.models.*
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {
    @POST("students/register")
    suspend fun registerStudent(@Body registrationRequest: RegistrationRequest):Response<RegistrationResponse>
    @POST("students/login")
    suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>
    @GET("/courses")
    suspend fun  course(@Header("Authorization") token: String):Response<List<CourseResponse>>





    }
