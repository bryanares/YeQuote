package com.brian.tellinye.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.brian.tellinye.models.Ye


@Dao
interface QuotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuote (quote : Ye)

    @Query("SELECT * FROM yeQuotesDb")
    fun getAllQuotes() : List<Ye>
}