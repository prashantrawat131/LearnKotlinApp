package com.example.learnkotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnkotlinapp.databinding.ActivityAlertsBinding

class AlertsActivity : AppCompatActivity() {
    var a = 10

    lateinit var binding: ActivityAlertsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener { showSimpleAlert() }

        binding.button4.setOnClickListener { showCustomDialog() }

    }

    private fun showCustomDialog() {
        val customAlertFragment = CustomAlertFragment(this)
        customAlertFragment.show(supportFragmentManager, "TagForSupportFragmentManager")
    }

    private fun showSimpleAlert() {
        val simpleDialogFragment = SimpleDialogFragment(this)
        simpleDialogFragment.show(supportFragmentManager, "TagForSimpleDialogFragment")
    }
}