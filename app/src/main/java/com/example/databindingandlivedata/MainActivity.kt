package com.example.databindingandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import android.widget.Toast

import androidx.lifecycle.ViewModelProvider

import com.example.databindingandlivedata.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModelFactory : ViewModelProvider.AndroidViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        val mainViewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            this.setLifecycleOwner (this@MainActivity)
            this.viewmodel = mainViewModel
        }

        mainViewModel.currentRandomFruitName.observe(this,
            Observer {
                textView2.text = it.toString()
            })







    }
}
