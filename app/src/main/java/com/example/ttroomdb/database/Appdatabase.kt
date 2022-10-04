package com.example.ttroomdb.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ttroomdb.dao.UserDao
import com.example.ttroomdb.model.User

const val DATABASE_NAME = "user_database"
    @Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

}