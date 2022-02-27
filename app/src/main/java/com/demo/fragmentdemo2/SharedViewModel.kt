package com.demo.fragmentdemo2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    lateinit var text: MutableLiveData<String>

    init {
        text = MutableLiveData()
    }

    fun setText(input: String) {
        text.value = input
    }
}