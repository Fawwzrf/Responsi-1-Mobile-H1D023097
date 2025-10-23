package com.example.responsi1mobileh1d023097

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023097.databinding.ActivityCoachBinding
import com.example.responsi1mobileh1d023097.viewmodel.MainViewModel

class CoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding
    private val viewModel: MainViewModel by viewModels()
    private val TEAM_ID = 346

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeViewModel()
        viewModel.fetchTeamDetails(TEAM_ID)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun observeViewModel() {
        viewModel.teamDetails.observe(this) { searchResponse ->

            searchResponse?.coach?.let { coach ->
                binding.tvCoachName.text = coach.name
                binding.tvCoachBirthdate.text = coach.dateOfBirth
                binding.tvCoachNationality.text = coach.nationality

            } ?: run {
                binding.tvCoachName.text = "Data Pelatih Tidak Ditemukan"
                binding.tvCoachBirthdate.text = ""
                binding.tvCoachNationality.text = ""
            }
        }
    }
}