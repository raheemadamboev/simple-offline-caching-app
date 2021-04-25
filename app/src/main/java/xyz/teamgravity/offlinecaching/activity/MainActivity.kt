package xyz.teamgravity.offlinecaching.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import xyz.teamgravity.offlinecaching.arch.viewmodel.MainViewModel
import xyz.teamgravity.offlinecaching.databinding.ActivityMainBinding
import xyz.teamgravity.offlinecaching.helper.adapter.RestaurantAdapter
import xyz.teamgravity.offlinecaching.helper.util.Resource

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewmodel by viewModels<MainViewModel>()

    private lateinit var adapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            adapter = RestaurantAdapter()
            recyclerView.adapter = adapter

            viewmodel.restaurants.observe(this@MainActivity) { result ->
                adapter.submitList(result.data)

                when (result) {
                    is Resource.Error -> {
                        if (result.data.isNullOrEmpty()) {
                            progressBar.isVisible = false
                            errorT.isVisible = true
                            errorT.text = result.error?.localizedMessage
                        }
                    }

                    is Resource.Loading -> {
                        if (result.data.isNullOrEmpty()) {
                            progressBar.isVisible = true
                        }
                    }

                    is Resource.Success -> {
                        progressBar.isVisible = false
                        errorT.isVisible = false
                    }
                }
            }
        }
    }
}