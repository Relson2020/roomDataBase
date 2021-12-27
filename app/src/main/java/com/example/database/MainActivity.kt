package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var database: NoteDataBase? = null
    private  lateinit var recycle : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        database = NoteDataBase.getNOteDataBaseReference(this)

        recycle = binding.recyclerView

        binding.addDataButton.setOnClickListener{
            val intent = Intent(this,DataEntry::class.java)
            startActivity(intent)
        }

        database?.getNoteDao()?.getAllNotes()?.observe(this, Observer {

            val nameDisplay : ArrayList<String> = ArrayList()
            val phoneDisplay : ArrayList<Int> = ArrayList()
            val emailDisplay : ArrayList<String> = ArrayList()
            val employeeIdDisplay : ArrayList<String> = ArrayList()

            for (a in it){
                emailDisplay.add(a.email)
                nameDisplay.add(a.name)
                phoneDisplay.add(a.phone)
            }

            recycle.adapter = RecyclerAdapter(nameDisplay,phoneDisplay,emailDisplay)
        })

    }
}
