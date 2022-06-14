package com.mobwaysolutions.appdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        ProdutoEntidade::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getProdutoDAO() : ProdutoDAO

    companion object {

        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database_db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }

    }
}