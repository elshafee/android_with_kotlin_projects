package com.elshafee.bullrent

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_screen.password
import kotlinx.android.synthetic.main.activity_login_screen.password_toggle
import kotlinx.android.synthetic.main.activity_login_screen.sign_btn
import kotlinx.android.synthetic.main.activity_login_screen.text3
import kotlinx.android.synthetic.main.activity_sign_up_screen.*


class SignUpScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_screen)
        supportActionBar?.hide()
        text3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LoginScreen::class.java)
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

            val person_name = name.text.toString()
            val user_name = username.text.toString()
            val user_email = email.text.toString()
            val user_phone = phone.text.toString()
            val user_password = password.text.toString()
            var m = user_name.length - 1
            var hasspace = false

            for (i in 0..m) {
                var n = user_name[i]
                if (n == ' ') {
                    hasspace = true
                }
            }
            if (person_name.length < 3) {
                Toast.makeText(
                    this,
                    "Error!! your Name very short, Please check it again",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (user_name.length < 3 || hasspace) {
                    Toast.makeText(
                        this,
                        "Error!! Your username is taken before or has spaces, Please check it again",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    var to = isValidEmail(user_email)
                    to = !to
                    if (to) {
                        Toast.makeText(
                            this,
                            "Error!! Your email format is bad, Please check it again",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        if (user_phone.length < 11) {
                            Toast.makeText(
                                this,
                                "Error!! Your phone number is bad, Please check it again",
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
                                print("ok")
                                Toast.makeText(
                                    this,
                                    "Welcome ${person_name}",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, MainActivity::class.java)
                                intent.putExtra("key", person_name)
                                startActivity(intent)
                            }
                        }
                    }
                }

            }


        }


    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

}


