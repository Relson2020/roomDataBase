package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.database.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var database: NoteDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        database = NoteDataBase.getNOteDataBaseReference(GlobalInstance.getApplication())

        binding.addDataButton.setOnClickListener{
            val intent = Intent(this,DataEntry::class.java)
            startActivity(intent)
        }
        var data :List<NoteEntities>
        database?.getNoteDao()?.getAllNotes()?.observe(this, Observer {
                data = it
            val displayTemp = data.toString()
            binding.displayData.setText(displayTemp)
        })

    }
}
