package com.mobwaysolutions.appdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobwaysolutions.appdatabase.dao.ProdutoDAO
import com.mobwaysolutions.appdatabase.dao.ServicoDAO
import com.mobwaysolutions.appdatabase.dao.UsuarioDAO
import com.mobwaysolutions.appdatabase.dao.VendasDAO
import com.mobwaysolutions.appdatabase.entity.ProdutoEntidade
import com.mobwaysolutions.appdatabase.entity.ServicoEntidade
import com.mobwaysolutions.appdatabase.entity.UsuarioEntidade
import com.mobwaysolutions.appdatabase.entity.VendasEntidade

@Database(
    version = 1,
    entities = [
        ProdutoEntidade::class,
        UsuarioEntidade::class,
        VendasEntidade::class,
        ServicoEntidade::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getProdutoDAO(): ProdutoDAO
    abstract fun getUsuarioDAO(): UsuarioDAO
    abstract fun getVendasDAO(): VendasDAO
    abstract fun getServicoDAO(): ServicoDAO

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