package com.example.retrofitcoroutines1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.example.retrofitcoroutines1.Repository.Repository
import com.example.retrofitcoroutines1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
           if(response.isSuccessful){
binding.txtquote.text = response.body()?.quote
               Log.d("Kanye",response.body()?.quote.toString())
           }
            else{
            binding.txtquote.text = response.code().toString()
           }
        })
    }
}