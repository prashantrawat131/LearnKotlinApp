package com.example.learnkotlinapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnkotlinapp.coroutine.CoroutineExampleActivity
import com.example.learnkotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding;
    val arrayList: ArrayList<Person> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.tv.text = "Prashant";

        binding.button.setOnClickListener {
            val intent = Intent(this, ViewPagerActivity::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(this, AlertsActivity::class.java)
            startActivity(intent)
        })

        binding.imageView.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.run
            )
        )

        binding.button3.setOnClickListener(View.OnClickListener { view->
            startActivity(Intent(this,CoroutineExampleActivity::class.java))
        })

        setUpRecyclerView()

        Toast.makeText(
            applicationContext, "Hello", Toast.LENGTH_LONG
        ).show()
    }

    private fun setUpRecyclerView() {
        arrayList.add(Person("Prashant", "3232424"))
        arrayList.add(Person("Raman", "7756"))
        arrayList.add(Person("Deep", "534"))
        arrayList.add(Person("Suraj", "44"))

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyRecyclerViewAdapter(arrayList, applicationContext)

    }
}