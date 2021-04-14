package com.example.SoufianeJD_EscapeRoomsKotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        /** DISPLAY LIST OF ORDERS **/

        val url= "http://192.168.0.26/escaproomsscriptsphp/get_temp.php?mobile=" +UserInfo.mobile
        val list=ArrayList<String>()
        val rq: RequestQueue = Volley.newRequestQueue(this)
        val jar= JsonArrayRequest(Request.Method.GET,url,null, Response.Listener { response ->

            for (x in 0..response.length()-1)
                list.add("Title : "+ response.getJSONObject(x).getString("name") + "\n"
                        + "Price is: "+ response.getJSONObject(x).getString("price") + "  $ per 1h" +"\n"
                        + "Reservation for : "+ response.getJSONObject(x).getString("quantity") + " people")

            val adp= ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
            order_list.adapter=adp

        }, Response.ErrorListener { error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })
        rq.add(jar)

    }
            /** DISPLAY MENU ITEMS **/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
        /** WHEN A PARTICULAR ITEM IS CLICKED **/
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

            /**WHEN BACK TO MENU IS CLICKED**/
        if (item?.itemId==R.id.item_menu)
        {
            val i=Intent(this,HomeActivity::class.java)
            startActivity(i)
        }

            /**WHEN CANCEL IS CLICKED**/
        if (item?.itemId==R.id.item_cancel)
        {

            val url = "http://192.168.0.42/escaproomsscriptsphp/cancel_temp.php?mobile="+UserInfo.mobile
            val rq:RequestQueue=Volley.newRequestQueue(this)
            val sr = StringRequest(Request.Method.GET,url,Response.Listener { response ->

                val i = Intent(this,HomeActivity::class.java)
                startActivity(i)

            },Response.ErrorListener { error ->
                Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()

            })

            rq.add(sr)
        }
            /**WHEN CONFIRM ORDER IS CLICKED**/
            if (item?.itemId==R.id.item_confirm)
            {

                val url = "http://192.168.0.42/escaproomsscriptsphp/confirm_order.php?mobile="+UserInfo.mobile
                val rq:RequestQueue=Volley.newRequestQueue(this)
                val sr = StringRequest(Request.Method.GET,url,Response.Listener { response ->

                    val i = Intent(this,TotalActivity::class.java)
                    i.putExtra("bno",response)//we pass the bill number to the total activity
                    startActivity(i)

                },Response.ErrorListener { error ->
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()

                })

                rq.add(sr)

            }
        return super.onOptionsItemSelected(item)
    }
}