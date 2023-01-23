package com.example.learnkotlinapp.coroutine

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import com.android.volley.toolbox.Volley
import com.example.learnkotlinapp.databinding.ActivityCoroutineExampleBinding
import kotlinx.coroutines.launch

class CoroutineExampleActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoroutineExampleBinding
    private val viewModel = MyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener { search() }

        binding.dataTv.movementMethod = ScrollingMovementMethod()
    }

    private fun search() {
        val requestQueue = Volley.newRequestQueue(applicationContext)

        viewModel.viewModelScope.launch {
            viewModel.get(binding.searchEt.text.toString(), requestQueue, setUI= { str ->
                binding.dataTv.text = str
            })

        }
    }
}