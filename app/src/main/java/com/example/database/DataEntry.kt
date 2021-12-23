package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.database.databinding.ActivityDataEntryBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DataEntry : AppCompatActivity() {

    private lateinit var binding : ActivityDataEntryBinding
    private var database: NoteDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //dataBinding

        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_entry)

        //dataBase instance

        database = NoteDataBase.getNOteDataBaseReference(GlobalInstance.getApplication())

        binding.SaveDataButton.setOnClickListener{
            val name = binding.nameEditText.text.toString()
            val phoneTemp = binding.phoneEditText.text.toString()
            val phone = phoneTemp.toInt()
            val employeeTemp = binding.employeeEditText.text.toString()
            val employee = employeeTemp.toInt()
            val email = binding.emailEditText.text.toString()
            GlobalScope.launch(Dispatchers.IO) {

                database?.getNoteDao()?.insert(NoteEntities(employee,name,phone,email))
            }

           // val intent =  Intent(this,MainActivity::class.java)
        //startActivity(intent)

        }


    }
}