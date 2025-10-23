package com.example.responsi1mobileh1d023097

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobileh1d023097.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }
    private fun initLayout(){
        binding.layoutHistory.let {
            it.imgIcon.setImageResource(R.drawable.ball_icon)
            it.tvLayout.setText(R.string.history)
        }

        binding.layoutCoach.let {
            it.imgIcon.setImageResource(R.drawable.coach_icon)
            it.tvLayout.setText(R.string.coach)
        }

        binding.layoutSquad.let {
            it.imgIcon.setImageResource(R.drawable.team_icon)
            it.tvLayout.setText(R.string.squad)
        }

    }
    private fun initListener(){
        binding.layoutHistory.root.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        binding.layoutCoach.root.setOnClickListener {
            startActivity(Intent(this, CoachActivity::class.java))
        }

        binding.layoutSquad.root.setOnClickListener {
            startActivity(Intent(this, SquadActivity::class.java))
        }
    }

}
