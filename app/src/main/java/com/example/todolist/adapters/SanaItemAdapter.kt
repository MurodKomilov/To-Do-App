package com.example.todolist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.Sana
import com.example.todolist.databinding.SanaItemBinding

class SanaItemAdapter(var sanaList: ArrayList<Sana>): RecyclerView.Adapter<SanaItemAdapter.MyViewHolder>(){

    inner class MyViewHolder(var binding: SanaItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(list: Sana){
            binding.sanaNumber.text = list.number
            binding.sanaDay.text = list.day
        }
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