package com.example.ds

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ds.databinding.ActivitySignInBinding
import com.example.ds.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth=FirebaseAuth.getInstance()
        binding.textview.setOnClickListener({
            val intent=Intent(this,SignInActivity::class.java)
            startActivity(intent)
        })
        binding.button.setOnClickListener{
            var email=binding.email.text.toString()
            var pass=binding.password.text.toString()
            var confirm=binding.retypepassword.text.toString()
            if(email.isNotEmpty()&& pass.isNotEmpty()&& confirm.isNotEmpty()){
                if(pass==confirm){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                      if(it.isSuccessful){
                          val intent=Intent(this,SignInActivity::class.java)
                          startActivity(intent)
                      }else{
                          Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                      }
                    }
                }
                else{
                    Toast.makeText(this,"password is not matching",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"empty fields are not allowed",Toast.LENGTH_SHORT).show()
            }
        }
    }
}