package com.example.learnkotlinapp

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.learnkotlinapp.databinding.CustomAlertLayoutBinding

class CustomAlertFragment(private val fa: Activity) : DialogFragment() {
    var a = 10
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(fa);

        var binding = CustomAlertLayoutBinding.inflate(fa.layoutInflater)

        builder.apply {
            setTitle("Enter your details")

            setView(binding.root)

            /* setSingleChoiceItems(R.array.colors, -1,
                 DialogInterface.OnClickListener { dialogInterface, i ->
                     Toast.makeText(fa.applicationContext, "i: " + i, Toast.LENGTH_SHORT).show()
                 })*/

            setPositiveButton("Ok", DialogInterface.OnClickListener() { dialogInterface, i ->
                Toast.makeText(
                    fa.applicationContext,
                    "" + binding.name.text + " " + binding.phoneNumber.text,
                    Toast.LENGTH_LONG
                ).show()

                dialogInterface.dismiss()
            })

            setNegativeButton("Cancel", DialogInterface.OnClickListener() { dialogInterface, i ->
                dialogInterface.dismiss()
            })
        }

//        Log.d("tagJi", ret.toString())

        return builder.create()
    }
}