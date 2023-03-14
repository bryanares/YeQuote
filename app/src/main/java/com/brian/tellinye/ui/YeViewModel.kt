package com.brian.tellinye.ui


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brian.tellinye.models.Ye
import com.brian.tellinye.repositories.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class YeViewModel(private val yeRepository: QuotesRepository) : ViewModel() {

    //response variable
    private val yeQuote = MutableLiveData<Ye>()
    val yeQuotes: LiveData<Ye> get() = yeQuote

    init {
        getQuote()
    }

    //function to get the quote
    fun getQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = yeRepository.getYeQuote() ?: Ye()
            Log.d("", "the response is $response")
            yeQuote.postValue(response)
        }
    }
//    fun getYeQuote(): MutableLiveData<Ye> {
//        viewModelScope.launch {
//            try {
//                _ye.value = YeApi.retrofitService.getYe()
//            }catch (e: Exception){
//                Log.e("ViewModel", "Error fetching data")
//            }
//        }
//        return _ye
//    }
}
//class YeViewModelFactory(private val yeRepository: QuotesRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(YeViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return YeViewModel(yeRepository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}