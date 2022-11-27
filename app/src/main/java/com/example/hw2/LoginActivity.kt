package com.example.hw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val viewModel = ViewModelProvider(this).get(viewmodel::class.java)


        var btn:Button = findViewById(R.id.loginbtn);
        var account:EditText = findViewById(R.id.editText)
        var password:EditText = findViewById(R.id.editText2)


        btn.setOnClickListener {
            var acc = account.text.toString()
            var pass = password.text.toString()
            var isSuccess = false

            when(viewModel.login(acc,pass)){
                0 -> isSuccess = false
                1 -> isSuccess = true
            }

            if(isSuccess){
                val loginAccount =viewModel.getLoginData()
                if (loginAccount != null) {
                    GlobalVariable.setAccount(loginAccount)
                }
                Toast.makeText(this, loginAccount?.name+" 登入成功!", Toast.LENGTH_SHORT).show();
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "帳號密碼錯誤", Toast.LENGTH_SHORT).show();
            }

        }
    }

    override fun onStart() {
        var account:EditText = findViewById(R.id.editText)
        var password:EditText = findViewById(R.id.editText2)
        account.text=null
        password.text=null
        super.onStart()
    }
}