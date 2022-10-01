package com.brian.tellinye.ui


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brian.tellinye.network.Ye
import com.brian.tellinye.network.YeApi
import kotlinx.coroutines.launch
import java.lang.Exception

class YeViewModel: ViewModel() {

    //response variable
    private val _ye = MutableLiveData<Ye>()
    val ye : LiveData<Ye> = _ye


    //function to get the quote
    fun getYeQuote(): MutableLiveData<Ye> {
        viewModelScope.launch {
            try {
                _ye.value = YeApi.retrofitService.getYe()
            }catch (e: Exception){
                Log.e("ViewModel", "Error fetching data")
            }
        }
        return _ye
    }
}