package com.example.databindingandlivedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingandlivedata.databinding.ActivityMain2Binding
import com.example.databindingandlivedata.databinding.ActivityMainBinding

class Main2Activity : AppCompatActivity() {
    lateinit var viewModelFactory : ViewModelProvider.AndroidViewModelFactory
    lateinit var mainViewModel :MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        getViewInstance()
        dataBinding()

    }

    fun getViewInstance(){
        viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        mainViewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
    }

    fun dataBinding(){
        DataBindingUtil.setContentView<ActivityMain2Binding>(
            this, R.layout.activity_main2
        ).apply {
            this.setLifecycleOwner (this@Main2Activity)
            this.viewmodel = mainViewModel
            this.acitivy = this@Main2Activity
        }
    }

    fun nextActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
