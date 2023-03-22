package com.brian.tellinye.repositories

import android.app.Application
import android.util.Log
import com.brian.tellinye.database.QuotesDatabase
import com.brian.tellinye.models.Ye
import com.brian.tellinye.network.YeApi


class QuotesRepository(private val application : Application) {

    suspend fun getYeQuote() : Ye? {

        return try {
            //make network call and insert fetched data into database
            val quote = YeApi.retrofitService.getYe()
            val quotesDatabase = QuotesDatabase.getDatabase(application)
            Log.d("Repo", "Quote is $quote")

            val quotesDao = quotesDatabase.quotesDao()
            quotesDao!!.insertQuote(quote)


            //extract all saved quotes from db
            val allQuotes = quotesDao.getAllQuotes()
            Log.d("All the quotes are", allQuotes.toString())

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