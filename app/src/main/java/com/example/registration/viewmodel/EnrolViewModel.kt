package com.example.registration.viewmodel

import android.media.session.MediaSession
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registration.models.EnrolmentRequest
import com.example.registration.models.EnrolmentResponse
import com.example.registration.repository.CourseRepository
import kotlinx.coroutines.launch

class EnrolViewModel :ViewModel(){
    var enrolLiveData= MutableLiveData<EnrolmentResponse>()
    var enrolFailedLiveData= MutableLiveData<String>()
    var courseRepository=CourseRepository()

    fun getEnrolment(accessToken: String){
        viewModelScope.launch {
            var response=courseRepository.enrolment(accessToken)
            if (response.isSuccessful){
                enrolLiveData.postValue(response.body())
            }
            else{
                enrolFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}

