package com.example.ttroomdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.ttroomdb.database.AppDatabase
import com.example.ttroomdb.database.DATABASE_NAME
import com.example.ttroomdb.databinding.ActivityMainBinding
import com.example.ttroomdb.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch {
            getDataBase().userDao().insertAll(User(null, "abc", "abc"))
        }

    }

     private fun getDataBase(): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).enableMultiInstanceInvalidation().build()
    }
}