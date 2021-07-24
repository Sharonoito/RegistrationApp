package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//class Courses : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_courses2)
//    }
//}
data class Courses(
    var courseName:String,
    var courseCode:String,
    var description:String,
    var instructor:String
)
