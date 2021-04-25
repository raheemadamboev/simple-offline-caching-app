package xyz.teamgravity.offlinecaching.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import xyz.teamgravity.offlinecaching.R
import xyz.teamgravity.offlinecaching.arch.viewmodel.MainViewModel
import xyz.teamgravity.offlinecaching.databinding.ActivityMainBinding
import xyz.teamgravity.offlinecaching.helper.adapter.RestaurantAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewmodel by viewModels<MainViewModel>()

    private lateinit var adapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RestaurantAdapter()
        binding.recyclerView.adapter = adapter

        viewmodel.restaurants.observe(this) {
            adapter.submitList(it)
        }

    }
}