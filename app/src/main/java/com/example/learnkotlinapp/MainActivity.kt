package com.example.learnkotlinapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnkotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding;
    val arrayList: ArrayList<Person> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.tv.text = "Prashant";

        binding.button.text="Go To next activity"
        binding.button.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Hello",
                Toast.LENGTH_LONG
            ).show()

            val intent = Intent(this, ViewPagerActivity::class.java)
            startActivity(intent)
        }

        binding.imageView.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext,
                R.drawable.run
            )
        )

        setUpRecyclerView()

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