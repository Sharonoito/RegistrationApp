package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.models.RegistrationRequest
import com.example.registration.models.RegistrationResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etDob: EditText
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var etPhonenumber: EditText
    lateinit var btnRegister: Button
    lateinit var spNationality: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        clickRegister()
    }

    fun castViews() {
        etName = findViewById(R.id.etName)
        etDob = findViewById(R.id.etDob)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etPhonenumber = findViewById(R.id.etPhonenumber)
        btnRegister = findViewById(R.id.btnRegister)
        spNationality = findViewById(R.id.spNationality)

        val nationalities = arrayOf("KENYA", "RWANDAN", "UGANDAN", "SOUTH SUDAN")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nationalities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spNationality.adapter = adapter
        clickRegister()

    }

    fun clickRegister() {
        var error=false
        btnRegister.setOnClickListener {
            var name = etName.text.toString()
            if (name.isEmpty()) {
                error=true
                etName.setError("Name is required")
            }
            var dob = etDob.text.toString()
            if (dob.isEmpty()) {
                error=true
                etDob.setError("Date of birth is required")
            }
            var nationality = spNationality.selectedItem.toString()
//           var nationality=spNationality.text.toString()
//          if(nationality.isEmpty()){
//               spNationality.setError("Nationality is required")
//          }
            var email = etEmail.text.toString()
            if (email.isEmpty()) {
                error=true
                etEmail.setError("Email is required")
            }
            var password = etPassword.text.toString()
            error=true
            if (password.isEmpty()) {
                etPassword.setError("Id number required")
            }
            var phonenumber = etPhonenumber.text.toString()
            error=true
            if (phonenumber.isEmpty()) {
                etPhonenumber.setError("Phone number is required")
            }

            var registrationRequest = RegistrationRequest(
                name = name,
                phoneNumber = phonenumber,
                email = email,
                nationality = nationality.uppercase(),
                dataOfBirth = dob,
                password = password
            )
            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.registerStudent(registrationRequest)
            request.enqueue(object :Callback<RegistrationResponse>{
                override fun onResponse(call: Call<RegistrationResponse>,response: Response<RegistrationResponse>
                ) {

                    if (response.isSuccessful){
                        Toast.makeText(baseContext,"Registration Successful",Toast.LENGTH_LONG).show()
                        var intent=Intent(baseContext,LoginActivity::class.java)
                        startActivity(intent)
                    }


                    else{
                        try {
                            val error=JSONObject(response.errorBody()!!.string())
                            Toast.makeText(baseContext,error.toString(),Toast.LENGTH_LONG).show()
                        }catch (e:Exception){
                            Toast.makeText(baseContext,e.message,Toast.LENGTH_LONG).show()

                        }
                    }
                }

                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                    Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

                }
            })

        }
    }
}
data class ApiError(var errors:List<String>)



