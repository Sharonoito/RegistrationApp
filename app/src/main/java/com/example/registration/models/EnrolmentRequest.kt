package com.example.registration.models

import com.google.gson.annotations.SerializedName

data class EnrolmentRequest(
    @SerializedName("course_id") var courseId: String,
    @SerializedName("student_id") var studentId: String,
)
