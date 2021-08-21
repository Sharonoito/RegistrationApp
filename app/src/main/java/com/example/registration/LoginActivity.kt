package com.example.registration

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.databinding.ActivityLoginBinding
import com.example.registration.databinding.ActivityMainBinding
import com.example.registration.models.LoginRequest
import com.example.registration.models.LoginResponse
import com.example.registration.ui.CourseResponseActivity
import com.example.registration.viewmodel.Constants
import com.example.registration.viewmodel.LoginViewModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    val loginViewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences=getSharedPreferences("CODEHIVE_REG_PREF",Context.MODE_PRIVATE)


            startActivity(Intent(baseContext, CourseResponseActivity::class.java))


    }
    override fun onResume() {
        super.onResume()
        binding.btnLogin.setOnClickListener {
            var error=false

        }
        validateLogin()


        loginViewModel.loginLiveData.observe(this, { loginResponse ->
            binding.pbLogin.visibility = View.GONE
            Toast.makeText(baseContext, loginResponse.message, Toast.LENGTH_LONG).show()

            var editor = sharedPreferences.edit()
            editor.putString("ACCESS_TOKEN", loginResponse.accessToken)

            editor.putString(Constants.STUDENT_ID, loginResponse.studentId)
            editor.apply()

            sharedPreferences.edit().putString("ACCESS_TOKEN", loginResponse.accessToken).apply()

        })

        loginViewModel.loginFailedLiveData.observe(this, { error ->
            binding.pbLogin.visibility = View.GONE
            Toast.makeText(baseContext, error,Toast.LENGTH_LONG).show()
//            binding.tvLogginError.visibility = view.VISIBLE
//            binding.tvLoginError.text = error
        })
    }
    fun validateLogin(){
        var error=false
        var email=binding.etEmail1.text.toString()
            if (email.isEmpty()){
                binding.etEmail1.setError("Email Required")
            }
            var password=binding.etPassword1.text.toString()
            if (password.isEmpty()){
                error=true
                binding.etPassword1.setError("Password Required")
            }

            var LoginRequest=LoginRequest(
                email=email,
                password=password
            )

    }
}









