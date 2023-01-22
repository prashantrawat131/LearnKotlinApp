package com.example.learnkotlinapp

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class SimpleDialogFragment(private val fa: Activity) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialogBuilder = AlertDialog.Builder(fa)

        alertDialogBuilder.setTitle("Hello!")
        alertDialogBuilder.setMessage("This is some message for you.")

        alertDialogBuilder.setPositiveButton("Ok") { dialogInterface, i ->
            dialogInterface.dismiss()
        }

        alertDialogBuilder.setNegativeButton("Cancel") { dialogInterface, i ->
            dialogInterface.dismiss()
        }

        return alertDialogBuilder.create()
    }
}