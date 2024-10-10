package com.example.todolist

import TasksItemAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapters.SanaItemAdapter
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.databinding.SanaItemBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    var sanaList = ArrayList<Sana>()
    var tasksList = ArrayList<Tasks>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sanaList.apply {
            add(Sana("5","Thur"))
            add(Sana("6","Fri"))
            add(Sana("7","Sat"))
            add(Sana("8","Sun"))
            add(Sana("9","Mon"))
            add(Sana("10","Tues"))
            add(Sana("11","Wed"))
        }

        tasksList.apply {
            add(Tasks("1:00 PM","Go to church"))
            add(Tasks("2:00 PM","Cook for the family"))
            add(Tasks("3:00 PM","Wash my clothes"))
            add(Tasks("4:00 PM","Visit Chastity"))
            add(Tasks("5:00 PM","Visit Chastity"))
            add(Tasks("6:00 PM","Call my brother"))
            add(Tasks("7:00 PM","Go to church"))
            add(Tasks("8:00 PM","Cook for the family"))
            add(Tasks("9:00 PM","Wash my clothes"))
        }


        var sanaItemAdapter = SanaItemAdapter(sanaList)
        var tasksItemAdapter = TasksItemAdapter(tasksList)
        var myLayoutManager =LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        var tasksLayoutManager =LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        sanaItemAdapter.setListener(object : RecyclerListener {
            override fun onCklickItem(binding1: SanaItemBinding) {
                binding1.apply {
                    sanaImage.setImageResource(R.drawable.color_back2)
                    sanaDay.textSize = 15F
                    sanaNumber.textSize = 15F

                    cardView.getLayoutParams().height = 100
                    cardView.getLayoutParams().width = 100
                }


            }

        })

        binding.recyclerViewTasks.apply {
            adapter = tasksItemAdapter
            layoutManager = tasksLayoutManager
            addItemDecoration(DividerItemDecoration(this@MainActivity, tasksLayoutManager.orientation))
        }


        binding.recyclerViewSana.apply {
            adapter = sanaItemAdapter
            layoutManager = myLayoutManager
            addItemDecoration(DividerItemDecoration(this@MainActivity, myLayoutManager.orientation))
        }



    }
}