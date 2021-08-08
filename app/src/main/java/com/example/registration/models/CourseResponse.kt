package com.example.registration.models

import com.google.gson.annotations.SerializedName

data class CourseResponse(
    @SerializedName("date_created") var date_created: String,
    @SerializedName("date_updated") var date_updated: String,
    @SerializedName("created_by") var created_by: String,
    @SerializedName("updated_by") var updated_by: String,
    var active: Boolean,
    @SerializedName("course_id") var course_id: String,
    @SerializedName("course_name") var course_name: String,
    @SerializedName("course_code") var course_code: String,
    var description: String,
    var instructor: String,

    )








