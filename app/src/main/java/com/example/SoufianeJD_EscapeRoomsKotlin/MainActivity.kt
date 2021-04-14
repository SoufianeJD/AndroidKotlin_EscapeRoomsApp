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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn.setOnClickListener {

        val url = "http://192.168.0.26/escaproomsscriptsphp/login.php?mobile=" + login_mobile.text.toString() + "&password=" + login_pw.text.toString()

        val rq: RequestQueue = Volley.newRequestQueue(this)
        val sr= StringRequest(Request.Method.GET,url, Response.Listener { response ->

            //check validation
            if(TextUtils.isEmpty(login_mobile.text.toString()) and  TextUtils.isEmpty(login_pw.text.toString()) ){
                login_mobile.setError("Please Provide a Phone Number");
                login_pw.setError("Please Provide a Password");

            }

            else if(response.equals("0")) {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }

            else {
                Toast.makeText(this, "Login Successfull!", Toast.LENGTH_SHORT).show()

                UserInfo.mobile = login_mobile.text.toString()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }, Response.ErrorListener { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()

        })

        rq.add(sr)
        }
                        /**WHEN SIGN UP BUTTON IS PRESSED**/
        signup_btn.setOnClickListener {

            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}