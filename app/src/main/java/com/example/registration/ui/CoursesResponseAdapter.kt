package com.example.registration.ui

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registration.R
import com.example.registration.models.CourseResponse
import com.example.registration.models.EnrolmentRequest
import com.example.registration.viewmodel.Constants
import com.example.registration.viewmodel.EnrolViewModel


class CoursesResponseAdapter(var courseResponseList:List<CourseResponse>):RecyclerView.Adapter<CoursesResponseViewHolder>() {
    private lateinit var enrolViewModel: EnrolViewModel
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesResponseViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.course_response_list_item,parent,false)
        return CoursesResponseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesResponseViewHolder, position: Int) {
        var currentCourseResponse=courseResponseList.get(position)

        holder.tvcourseName.text=currentCourseResponse.courseName
        holder.tvcourseId.text=currentCourseResponse.courseId
        holder.tvinstructor.text=currentCourseResponse.instructor
        holder.tvdescription.text=currentCourseResponse.description

        holder.btnEnrol.setOnClickListener {
            sharedPreferences=sharedPreferences
            var studentId=sharedPreferences.edit()
            var courseId = sharedPreferences.edit()
            var enrolmentRequest=EnrolmentRequest(
                studentId = studentId.toString(),
                courseId = courseId.toString()
            )
            enrolViewModel.getEnrolment(Constants.toString())
        }
    }

    override fun getItemCount(): Int{
        return courseResponseList.size
    }
}

class CoursesResponseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvcourseName=itemView.findViewById<TextView>(R.id.tvcourseName)
    var tvcourseId=itemView.findViewById<TextView>(R.id.tvcourseId)
    var tvdescription=itemView.findViewById<TextView>(R.id.tvdescription)
    var tvinstructor=itemView.findViewById<TextView>(R.id.tvinstructor)
    var  btnEnrol=itemView.findViewById<TextView>(R.id.btnEnrol)

}
