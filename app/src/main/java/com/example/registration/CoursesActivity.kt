package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        var rvCourses=findViewById<RecyclerView>(R.id.rvCourses)
        var courseList= listOf(
            Courses("MB101","Mobile development","Introduction to Android","John"),
            Courses("BE201","Backend Development","Introduction to Python","James"),
            Courses("IT301","IOT","I0T implementation","Barre"),
            Courses("Fe202","Frontend Development","Introduction to JavaScript","Veronicah"),
            Courses("ID5II","Industrial Design","Introduction to Industrial Design","Barre"),
            Courses("UI311","UI/UX Research","Introduction to UI/UX research","Erick")

        )
        var coursesAdapter=CoursesAdapter(courseList)
        rvCourses.layoutManager=LinearLayoutManager(baseContext)
        rvCourses.adapter=coursesAdapter
    }
}
