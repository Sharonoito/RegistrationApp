package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.databinding.ActivityLoginBinding
import com.example.registration.databinding.ActivityMainBinding
import com.example.registration.models.RegistrationRequest
import com.example.registration.models.RegistrationResponse
import com.example.registration.viewmodel.UserViewModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var nationalities= arrayOf("KENYAN","RWANDAN","SOUTHSUDAN","UGANDAN")
        val nationalitiesAdapter=ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,nationalities)
        nationalitiesAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        binding.spNationality.adapter=nationalitiesAdapter
    }
    override fun onResume() {
        super.onResume()
        binding.btnRegister.setOnClickListener {
            var registrationRequest = RegistrationRequest(
                name = binding.etName.text.toString(),
                phoneNumber = binding.etPhonenumber.text.toString(),
                email = binding.etEmail.text.toString(),
                dateOfBirth = binding.etDob.text.toString(),
                password = binding.etPassword.text.toString(),
                nationality = binding.spNationality.selectedItem.toString()
            )
            userViewModel.registerUser(registrationRequest)
        }
        userViewModel.registrationLiveData.observe(this, { registrationResponse ->
            if (!registrationResponse.studentId.isNullOrEmpty()) {
                var intent = Intent(baseContext, LoginActivity::class.java)
                startActivity(intent)
                Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.regFailedLiveData.observe(this, { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }}
//data class ApiError(var errors:List<String>)








