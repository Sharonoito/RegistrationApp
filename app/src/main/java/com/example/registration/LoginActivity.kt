package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.models.LoginRequest
import com.example.registration.models.LoginResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    lateinit var etEmail1:EditText
    lateinit var etPassword1:EditText
    lateinit var btnLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        castViews()

    }
    fun castViews(){
        etEmail1=findViewById(R.id.etEmail1)
        etPassword1=findViewById(R.id.etPassword1)
        btnLogin=findViewById(R.id.btnLogin)
        clickRegister()
    }
    fun  clickRegister(){
        var error=false
        btnLogin.setOnClickListener {
            var email=etEmail1.text.toString()
            if (email.isEmpty()){
                error=true
                etEmail1.setError("Email is required")
            }
            var password=etPassword1.text.toString()
            if (password.isEmpty()){
                error=true
                etPassword1.setError("Password is required")
            }
            var loginRequest=LoginRequest(
                email=email,password=password
            )
            val retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
            var request=retrofit.login(loginRequest)
            request.enqueue(object :Callback<LoginResponse>{
                override fun onResponse(call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(baseContext,"Login successful",Toast.LENGTH_LONG).show()
                        var intent=Intent(baseContext,CoursesActivity::class.java)
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

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                }
            })

        }
    }
}
