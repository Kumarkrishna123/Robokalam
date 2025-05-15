package com.example.robokalam

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.robokalam.Adapter.PortfolioAdapter
import com.example.robokalam.Model.Portfolio
import com.example.robokalam.Viewmodel.PortfolioViewModel
import com.example.robokalam.databinding.ActivityLoginBinding
import com.example.robokalam.databinding.ActivityPortfolioBinding


class PortfolioActivity : AppCompatActivity() {

    private lateinit var viewModel: PortfolioViewModel
    private lateinit var portfolioAdapter: PortfolioAdapter
    private lateinit var binding : ActivityPortfolioBinding
    private val portfolioList = mutableListOf<Portfolio>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPortfolioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameEdt  = binding.nameEt
        val collegeEdt = binding.collageNameEt
        val skillsEdt = binding.skillEt
        val titleEdt = binding.projectTittleEt
        val descriptionEdt = binding.descriptionEt
        val addBtn = binding.saveBtn

        val recyclerView =  binding.recyclerViewPortfolio

        //.2 Setup RecyclerView
        portfolioAdapter = PortfolioAdapter(portfolioList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = portfolioAdapter


        //3. Setup ViewModel
        viewModel = ViewModelProvider(this).get(PortfolioViewModel::class.java)

        viewModel.getAllPortfolio.observe(this) { list ->
            portfolioList.clear()
            portfolioList.addAll(list)
            portfolioAdapter.notifyDataSetChanged()
        }


        addBtn.setOnClickListener {

            val name = nameEdt.text.toString().trim()
            val college = collegeEdt.text.toString().trim()
            val skills = skillsEdt.text.toString().trim()
            val title = titleEdt.text.toString().trim()
            val desc = descriptionEdt.text.toString().trim()

            if (name.isNotEmpty() && college.isNotEmpty() && skills.split(",").size >= 3 &&
                title.isNotEmpty() && desc.isNotEmpty()
            ) {

                val portfolio = Portfolio(
                    0,
                    name,
                    college,
                    skills,
                    title,
                    desc
                )
                viewModel.insert(portfolio)

                nameEdt.text.clear()
                collegeEdt.text.clear()
                skillsEdt.text.clear()
                titleEdt.text.clear()
                descriptionEdt.text.clear()
                Toast.makeText(this, "Portfolio Saved", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "Please fill all fields with at least 3 skills",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
}