package com.example.learnkotlinapp.coroutine

import android.util.Log
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyViewModel : ViewModel() {
    var response: String? = null

    suspend fun get(url: String, requestQueue: RequestQueue, setUI: (response: String) -> Unit) =
        withContext(Dispatchers.IO)
        {
            val stringRequest = StringRequest(
                Request.Method.GET,
                url,
                {
                    response = it.toString()

                    var str = it.toString()

                    str = str.replace("/>", "/>\n")
                    str = str.replace(";", ";\n")

                    setUI(str)
                }, {
                    Log.d("tagJi", "Volley error: " + it.message)
                })

            requestQueue.add(stringRequest)
        }

}