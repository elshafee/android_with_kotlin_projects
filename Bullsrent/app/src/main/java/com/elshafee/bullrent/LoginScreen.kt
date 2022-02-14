package com.elshafee.bullrent


import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        supportActionBar?.hide()



        text3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SignUpScreen::class.java)
            startActivity(intent)
        })
        password_toggle.setOnClickListener {
            var status = password.transformationMethod
            if (status == HideReturnsTransformationMethod.getInstance()) {
                password.transformationMethod = PasswordTransformationMethod.getInstance()
            } else {
                password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }
        }
        sign_btn.setOnClickListener {
            val user_name = username.text.toString()
            val user_password = password.text.toString()
            var hasspace = false
            var m = user_name.length - 1

            for (i in 0..m) {
                var n = user_name[i]
                if (n == ' ') {
                    hasspace = true
                }
            }
            if (user_name.length < 3 || hasspace) {
                Toast.makeText(
                    this,
                    "Error!! Your username is wrong or has spaces, Please check it again",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (user_password.length < 8) {
                    Toast.makeText(
                        this,
                        "Error!! Your password length must be > 8, Please check it again",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        "Welcome ${user_name}",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("key", user_name)
                    startActivity(intent)
                }
            }
        }


    }

}