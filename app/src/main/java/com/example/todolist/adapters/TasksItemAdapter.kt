package com.example.todolist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.Tasks
import com.example.todolist.databinding.TasksItemBinding

class TasksItemAdapter(var tasksList: List<Tasks>):RecyclerView.Adapter<TasksItemAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: TasksItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(list: Tasks){
            binding.tasksTime.text = list.time
            binding.tasksTask.text = list.tasks
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = TasksItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return tasksList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var list = tasksList[position]
        holder.bind(list)
    }
}