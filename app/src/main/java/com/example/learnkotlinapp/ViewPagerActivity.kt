package com.example.learnkotlinapp

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.learnkotlinapp.databinding.ActivityViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPagerBinding
    private var list: List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = listOf("Fragment 1", "Fragment 2", "Fragment 3")

        binding.pager.adapter = MyFragmentAdapter(list!!, this)

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = "${list!![position]}"
        }.attach()


        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.pager.currentItem == 0) {
                    onBackPressedDispatcher.onBackPressed();
                } else {
                    binding.pager.currentItem -= 1
                }
            }
        })
    }

    class MyFragmentAdapter(private val arrayList: List<String>, fa: ViewPagerActivity) :
        FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return arrayList.size
        }

        override fun createFragment(position: Int): Fragment {
            return BlankFragment.newInstance(arrayList[position])
        }
    }

}