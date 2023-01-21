package com.example.learnkotlinapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.learnkotlinapp.databinding.RvItemBinding

class MyRecyclerViewAdapter(private val items: ArrayList<Person>, val context: Context) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.b.nameTv.text = items[position].name
        holder.b.phoneNumberTv.text = items[position].phoneNumber
        holder.b.nameTv.setOnClickListener {
            Toast.makeText(context, "" + items[position].name, Toast.LENGTH_LONG).show()
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(val b: RvItemBinding) : ViewHolder(b.root) {

    }
}