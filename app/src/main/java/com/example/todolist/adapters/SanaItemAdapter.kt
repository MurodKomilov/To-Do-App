package com.example.todolist.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.RecyclerListener
import com.example.todolist.Sana
import android.graphics.Color
import com.example.todolist.databinding.SanaItemBinding

class SanaItemAdapter(var sanaList: ArrayList<Sana>): RecyclerView.Adapter<SanaItemAdapter.MyViewHolder>(){

    private var recyclerViewListener: RecyclerListener? = null

    inner class MyViewHolder(var binding: SanaItemBinding):RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                recyclerViewListener?.onCklickItem(binding)
            }
        }

        @SuppressLint("ResourceAsColor")
        fun bind(list: Sana){
            binding.sanaNumber.text = list.number
            binding.sanaDay.text = list.day
            binding.sanaImage.setImageResource(R.drawable.color_back1)
        }
    }

    fun setListener(listener: RecyclerListener) {
        recyclerViewListener = listener
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SanaItemAdapter.MyViewHolder {
        return MyViewHolder(SanaItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SanaItemAdapter.MyViewHolder, position: Int) {
        var list = sanaList[position]
        holder.bind(list)

    }

    override fun getItemCount(): Int {
        return sanaList.size
    }


}