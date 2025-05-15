package com.example.robokalam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.robokalam.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    companion object{
        const val SHARED_PREFS = "shared_prefs"
        const val EMAIL_KEY = "email_key"
        const val PASSWORD_KEY = "password_key"
    }

    private  lateinit  var  sharedPreferences: SharedPreferences
    private lateinit var binding : ActivityLoginBinding
    private var email : String?=null
    private var password : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emailEdt = binding.emailEdText
        val passwordEdt = binding.passwordEdText
        val loginBtn  = binding.buttonLogin

        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        email = sharedPreferences.getString("email_key", null)
        password =  sharedPreferences.getString("password_key" , null)

        loginBtn.setOnClickListener {
            if(TextUtils.isEmpty(emailEdt.text.toString()) && TextUtils.isEmpty(passwordEdt.text.toString()) ){
                Toast.makeText(this , "Please enter your email and password" , Toast.LENGTH_SHORT).show()
            }
            else{
                val editor =  sharedPreferences.edit()

                editor.putString(EMAIL_KEY , emailEdt.text.toString())
                editor.putString(PASSWORD_KEY , passwordEdt.text.toString())

                editor.apply()

                val intent = Intent(this@LoginActivity , DashboardActivity::class.java)
                startActivity(intent)
                   finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(email !=null && password != null){
            val intent = Intent(this@LoginActivity , DashboardActivity::class.java)
            startActivity(intent)
        }
    }


}