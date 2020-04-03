package com.example.databindingandlivedata

import android.content.Context
import android.content.Intent
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel() {
    val currentRandomFruitName : LiveData<String>
        get() = FakeRepository.currentRandomFruitName

    fun onChangeRandomFruitClick() = FakeRepository.changeCurrentRandomFruitName()

    private val _displayedEditTextContent = MutableLiveData<String>()
    val displayedEditTextContent : LiveData<String>
        get() = _displayedEditTextContent


}