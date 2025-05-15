package com.example.robokalam

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.robokalam.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

    val sharedPreferences = getSharedPreferences("shared_prefs" , MODE_PRIVATE)
        val usedEmail  = sharedPreferences.getString("email_key" , null)

        val welcomeTv = binding.welcomeTv
        welcomeTv.text = "Welcome, $usedEmail"

          binding.profileCard.setOnClickListener {
              startActivity(Intent(this, PortfolioActivity::class.java))
          }
        binding.quoteCard.setOnClickListener {
            startActivity(Intent(this, QuoteActivity::class.java))
        }
        binding.AboutCard.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

    }
}