package xyz.teamgravity.offlinecaching.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.teamgravity.offlinecaching.R
import xyz.teamgravity.offlinecaching.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}