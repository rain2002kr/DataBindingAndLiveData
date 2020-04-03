package com.example.databindingandlivedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingandlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModelFactory : ViewModelProvider.AndroidViewModelFactory
    lateinit var mainViewModel :MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getViewInstance()
        dataBinding()

    }

    fun getViewInstance(){
        viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        mainViewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
    }

    fun dataBinding(){
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            this.setLifecycleOwner (this@MainActivity)
            this.viewmodel = mainViewModel
            this.mainActVity = this@MainActivity
        }
    }

    fun nextActivity(){
        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }


}
