package com.example.registration.repository

import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CourseRepository {
    lateinit var sessionManager: SessionManager
 
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun courses():Response<List<CourseResponse>> = withContext(Dispatchers.IO){
        var response = apiInterface.course(token = "Bearer ${sessionManager.fetchAccToken()}")
        return@withContext response
    }}



