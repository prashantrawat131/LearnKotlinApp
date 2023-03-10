package com.example.learnkotlinapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.learnkotlinapp.databinding.FragmentBlankBinding

private const val ARG_PARAM1_TEXT = "param1"
private const val ARG_PARAM2 = "param2"

class BlankFragment : Fragment() {

//    New changes from Prashant.

    private var text: String? = null

//    This is my change

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(ARG_PARAM1_TEXT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val b: FragmentBlankBinding = FragmentBlankBinding.inflate(inflater, container, false)
        b.fragmentTv.text = text
        return b.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        @JvmStatic
        fun newInstance(text: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1_TEXT, text)
                }
            }
    }
}