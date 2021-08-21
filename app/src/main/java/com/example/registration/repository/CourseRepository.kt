package com.example.registration.repository

import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CourseRepository {
//    lateinit var sessionManager: SessionManager
 
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun courses(accessToken:String):Response<List<CourseResponse>> = withContext(Dispatchers.IO){

        var response=apiInterface.getCourses(accessToken)
        return@withContext response
    }
    suspend fun enrolment(accessToken:String):Response<EnrolmentResponse> =
        withContext(Dispatchers.IO){
        var enrol=apiInterface.getEnrolment(accessToken)
        return@withContext enrol
    }
}



