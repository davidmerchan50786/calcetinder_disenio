package com.example.calcetinder.datos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.calcetinder.modelo.Calcetin
import com.example.calcetinder.modelo.Match
import com.example.calcetinder.modelo.Usuario

@Database(entities = [Usuario::class, Calcetin::class, Match::class], version = 1, exportSchema = false)
abstract class CalcetinderDB : RoomDatabase() {
    abstract fun usuarioDAO(): UsuarioDAO
    abstract fun calcetinDAO(): CalcetinDAO
    abstract fun matchDAO(): MatchDAO

    companion object {
        @Volatile private var INSTANCE: CalcetinderDB? = null
        fun obtenerDB(context: Context): CalcetinderDB {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext,
                    CalcetinderDB::class.java, "calcetinder_db").build().also { INSTANCE = it }
            }
        }
    }
}