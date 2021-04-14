package com.example.SoufianeJD_EscapeRoomsKotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val cat:String =intent.getStringExtra("cat") //category variable cat is received from HomeActivity

        //CHANGE THE NAV BAR TITLE
        supportActionBar?.title = cat

        val url="http://192.168.0.26/escaproomsscriptsphp/get_items.php?category="+cat
        val list=ArrayList<Item>()

        val rq:RequestQueue=Volley.newRequestQueue(this)
        val jar=JsonArrayRequest(Request.Method.GET,url,null,Response.Listener { response ->

            for (x in 0..response.length()-1)
                list.add(Item(response.getJSONObject(x).getInt("id"),
                              response.getJSONObject(x).getString("name"),
                              response.getJSONObject(x).getDouble("price"),
                              response.getJSONObject(x).getString("photo")))

            val adp=ItemAdapter(this,list)
            item_rv.layoutManager = LinearLayoutManager(this)
            item_rv.adapter=adp

        },Response.ErrorListener { error ->
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })

        rq.add(jar)

    }
}
