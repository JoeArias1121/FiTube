package com.example.fitube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun getVid() {                                           //temp 54?
        for(i in 0 until 20) {
            val pokeApiClient = AsyncHttpClient()//https://pokeapi.co/api/v2/pokemon/{id or name}/
            pokeApiClient["https://pokeapi.co/api/v2/pokemon/$i/", object : JsonHttpResponseHandler() {
                override fun onSuccess(
                    statusCode: Int,
                    headers: Headers,
                    json: JsonHttpResponseHandler.JSON
                ) {
                    temp = json.jsonObject.getString("sprites")
                    var t = JSONObject(temp)
                    pimage = t.getString("front_default")

                    pokeList.add(pimage)
                    //al.add(pimage)

                    nameList.add(json.jsonObject.getString("name"))
                    /* t = JSONObject(temp2)// species: {}2keys
                     pokeName = t.getString("name")*/
                    heightList.add(json.jsonObject.getString("height"))
                    weightList.add(json.jsonObject.getString("weight"))

                    Log.d("Pokemon", "response successful$pokeList")

                }


                override fun onFailure(
                    statusCode: Int,
                    headers: Headers?,
                    errorResponse: String,
                    throwable: Throwable?
                ) {
                    Log.d("Pokemon Error", errorResponse)
                }
            }]
        }


    }
}