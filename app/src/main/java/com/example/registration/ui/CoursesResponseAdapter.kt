package com.example.registration.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.registration.R
import com.example.registration.models.CourseResponse


class CoursesResponseAdapter(var courseResponseList: CourseResponse):RecyclerView.Adapter<CoursesResponseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesResponseViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.course_response_list_item,parent,false)
        return CoursesResponseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesResponseViewHolder, position: Int) {
        var currentResponseCourse=courseResponseList.get(position)
        holder.tvdateCreated.text=currentResponseCourse.date_created
        holder.tvdateUpdated.text=currentResponseCourse.date_updated
        holder.tvcreatedBy.text=currentResponseCourse.created_by
        holder.tvupdatedBy.text=currentResponseCourse.updated_by
        holder.tvactive.text= currentResponseCourse.active.toString()
        holder.tvcourseId.text=currentResponseCourse.course_id
        holder.tvcourseName.text=currentResponseCourse.course_name
        holder.tvcourseCode.text=currentResponseCourse.course_code
        holder.tvdescription.text=currentResponseCourse.description
        holder.tvinstructor.text=currentResponseCourse.instructor
    }

    override fun getItemCount(): Int{
        return courseResponseList.size
    }
}

class CoursesResponseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvdateCreated=itemView.findViewById<TextView>(R.id.tvdateCreated)
    var tvdateUpdated=itemView.findViewById<TextView>(R.id.tvdateUpdated)
    var tvcreatedBy=itemView.findViewById<TextView>(R.id.tvcreatedBy)
    var tvupdatedBy=itemView.findViewById<TextView>(R.id.tvupdatedBy)
    var tvactive=itemView.findViewById<TextView>(R.id.tvactive)
    var tvcourseId=itemView.findViewById<TextView>(R.id.tvcourseId)
    var tvcourseName=itemView.findViewById<TextView>(R.id.tvcourseName)
    var tvcourseCode=itemView.findViewById<TextView>(R.id.tvcourseCode)
    var tvdescription=itemView.findViewById<TextView>(R.id.tvdescription)
    var tvinstructor=itemView.findViewById<TextView>(R.id.tvinstructor)
}
