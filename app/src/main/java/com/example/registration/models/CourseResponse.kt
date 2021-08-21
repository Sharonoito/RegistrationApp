package com.example.registration.models

import com.google.gson.annotations.SerializedName

data class CourseResponse(
    @SerializedName("course_id") var courseId: String,
    @SerializedName("course_name") var courseName: String,
    var description: String,
    var instructor: String,

    ) 









