package com.example.registration.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registration.R
import com.example.registration.databinding.ActivityCourseResponseBinding
import com.example.registration.viewmodel.CourseViewModel

class CourseResponseActivity :AppCompatActivity(){
    lateinit var binding: ActivityCourseResponseBinding
    val courseViewModel:CourseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_response)


        binding= ActivityCourseResponseBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    override fun onResume() {
        super.onResume()
        courseViewModel.courseResponse()
        var rvcourseResponse=binding.rvcourseResponse
        courseViewModel.courseLiveData.observe(this,{courseResponse->

            if (!courseResponse.course_id.isNullOrEmpty()){
                var coursesResponseAdapter=CoursesResponseAdapter(courseResponse)
                rvcourseResponse.layoutManager=LinearLayoutManager(baseContext)
                rvcourseResponse.adapter=coursesResponseAdapter
            }

        })

    }

     }








