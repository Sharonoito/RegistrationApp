package com.example.registration.models

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    var name:String,
    @SerializedName("phone_number")var phoneNumber:String,
    var email:String,
    @SerializedName("date_of_birth")var dataOfBirth:String,
    var nationality:String,
    var password:String,
    @SerializedName("student_id")var studentId:String
)

