package com.example.registration.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registration.models.CourseResponse
import com.example.registration.repository.CourseRepository
import kotlinx.coroutines.launch

class CourseViewModel:ViewModel() {
    var courseLiveData= MutableLiveData<CourseResponse>()
    var courseFailedLiveData= MutableLiveData<String>()
    var courseRepository= CourseRepository()

    fun courseResponse() {
        viewModelScope.launch{
            var response=courseRepository.courses()
            if(response.isSuccessful){
                courseLiveData.postValue(response.body())
            }
            else{
                courseFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}

private fun <T> MutableLiveData<T>.postValue(body: List<T>?) {

}









