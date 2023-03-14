package com.brian.tellinye.repositories

import android.util.Log
import com.brian.tellinye.database.QuotesDao
import com.brian.tellinye.models.Ye
import com.brian.tellinye.network.YeApi


class QuotesRepository(private val api : YeApi, private val yeDao: QuotesDao) {

    suspend fun getYeQuote() : Ye? {

        return try {
            //make network call and insert fetched data into database
            val quote = api.retrofitService.getYe()
            Log.d("Repo", "Quote is $quote")
            yeDao.insertQuote(quote)

            //extract all saved quotes from db
            val allQuotes = yeDao.getAllQuotes()
            Log.d("", "All quotes are $allQuotes")

            if (!allQuotes.isNullOrEmpty())
                allQuotes.first()
            else
                null
        }catch (e: Exception){
            Log.e("", "error $e")
            null
        }

    }
}