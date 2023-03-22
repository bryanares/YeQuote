package com.brian.tellinye.ui


import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brian.tellinye.models.Ye
import com.brian.tellinye.repositories.QuotesRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class YeViewModel() : ViewModel() {
    //response variable
    private val yeQuote = MutableLiveData<Ye>()
    val yeQuotes: LiveData<Ye> get() = yeQuote
    private var yeRepository : QuotesRepository? = null

    fun setRepo(application: Application){
        yeRepository = QuotesRepository(application)
    }

    //function to get the quote
    fun getQuote() {
        val coroutineExceptionHandler = CoroutineExceptionHandler {_, throwable ->
            throwable.printStackTrace()
        }
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val response = yeRepository!!.getYeQuote() ?: Ye()
            Log.d("", "the response is $response")
            yeQuote.postValue(response)
        }
    }
}