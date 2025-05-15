package com.example.robokalam

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.robokalam.Viewmodel.QuoteViewModel
import com.example.robokalam.databinding.ActivityQuoteBinding

class QuoteActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityQuoteBinding
    private lateinit var viewModel: QuoteViewModel


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quoteTv= binding.quoteTextView
        val authorTv= binding.authorTextView

        viewModel = ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory.getInstance(application)).
        get(QuoteViewModel::class.java)

        viewModel.quote.observe(this) {quote->
              quoteTv.text = "\"${quote.q}\""
            authorTv.text =  "-${quote.a}"
        }

             viewModel.getQuoteIfNeeded()

    }
}