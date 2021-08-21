package com.example.registration.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registration.LoginActivity
import com.example.registration.R
import com.example.registration.databinding.ActivityCourseResponseBinding
import com.example.registration.databinding.ActivityLoginBinding
import com.example.registration.viewmodel.Constants
import com.example.registration.viewmodel.CourseViewModel
import com.example.registration.viewmodel.LoginViewModel


class CourseResponseActivity :AppCompatActivity(){
    lateinit var binding: ActivityCourseResponseBinding
    lateinit var sharedPreferences:SharedPreferences
    val courseViewModel:CourseViewModel by viewModels()

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCourseResponseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences=getSharedPreferences(Constants.SHAREDPREFERENCE,Context.MODE_PRIVATE)

    }
    override fun onResume() {
        super.onResume()
        var accessToken=sharedPreferences.getString(Constants.toString(),"ACCESS_TOKEN")
//        var accessToken=sharedPreferences.getString(Constants,ACCESS_TOKEN,Constants.EMPTY_STRING)
        var bearer="Bearer $accessToken"

        if (accessToken!!.isNotEmpty()){
            courseViewModel.getCourses(bearer)
        }
        else{
            startActivity(Intent(baseContext,LoginActivity::class.java))
        }
        var rvcourseResponse=binding.rvcourseResponse
        rvcourseResponse.layoutManager=LinearLayoutManager(baseContext)
        courseViewModel.courseLiveData.observe(this,{coursesResponse->

            var coursesResponseAdapter=CoursesResponseAdapter(coursesResponse)
            rvcourseResponse.adapter=coursesResponseAdapter

        })

        courseViewModel.courseFailedLiveData.observe(this,{error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
        courseViewModel.getCourses(accessToken)
        
            }}










