package com.example.SoufianeJD_EscapeRoomsKotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

                        /**LOAD DATA TO LIST VIEW**/
                        val url = "http://192.168.0.26/escaproomsscriptsphp/get_category.php"
        val list=ArrayList<String>()
        val rq:RequestQueue=Volley.newRequestQueue(this)
        val jar=JsonArrayRequest(Request.Method.GET,url,null,Response.Listener { response ->

            for (x in 0..response.length()-1)
                list.add(response.getJSONObject(x).getString("category"))

            val adp=ArrayAdapter(this,R.layout.my_textview,list)
            list_category.adapter=adp

        },Response.ErrorListener { error ->

            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()

        })
        rq.add(jar)
                        /**WHEN A CAREGORY IS CLICKED IN LIST VIEW**/

        list_category.setOnItemClickListener { parent, view, position, id ->

            val cat:String=list[position]
            val obj=Intent(this,ItemActivity::class.java)
            obj.putExtra("cat",cat) //The "name" passes the category variable cat to ItemActivity
            startActivity(obj)
        }
    }
}