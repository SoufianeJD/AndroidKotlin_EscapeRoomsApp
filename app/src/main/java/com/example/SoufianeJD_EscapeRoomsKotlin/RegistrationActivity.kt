package com.example.SoufianeJD_EscapeRoomsKotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registration_btn.setOnClickListener {

            if(pw.text.toString().equals(confirm_pw.text.toString())){
                val url = "http://192.168.0.26/escaproomsscriptsphp/add_user.php?mobile=" + mobile.text.toString() + "&password=" + pw.text.toString() + "&name=" + fullname.text.toString() + "&address=" + mail.text.toString()

                val rq:RequestQueue=Volley.newRequestQueue(this)
                val sr=StringRequest(Request.Method.GET,url,Response.Listener { response ->

                    //check validation
                    if(TextUtils.isEmpty(mobile.text.toString()) and TextUtils.isEmpty(pw.text.toString()) and TextUtils.isEmpty(fullname.text.toString()) and TextUtils.isEmpty(mail.text.toString())){
                        Toast.makeText(this, "Input all fields", Toast.LENGTH_LONG).show()
                    }

                    else if(response.equals("0"))
                        Toast.makeText(this,"Mobile number already exists",Toast.LENGTH_LONG).show()
                    else {

                        UserInfo.mobile = mobile.text.toString()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)

                        Toast.makeText(this, "User created Successfully!", Toast.LENGTH_LONG).show()

                    }
                },Response.ErrorListener { error ->
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()

                })

                rq.add(sr)
            }

            else
                Toast.makeText(this,"Password do not match!",Toast.LENGTH_LONG).show()
        }
    }
}