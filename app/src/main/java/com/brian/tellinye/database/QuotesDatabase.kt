package com.brian.tellinye.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.brian.tellinye.models.Ye


@Database(entities = [Ye::class], version = 1, exportSchema = false)
abstract class QuotesDatabase : RoomDatabase(){

    //dao
    abstract fun quotesDao() : QuotesDao

    companion object {
        @Volatile
        private var INSTANCE: QuotesDatabase? = null
        fun getDatabase(context: Context): QuotesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuotesDatabase::class.java,
                    "yeQuotesDb"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}