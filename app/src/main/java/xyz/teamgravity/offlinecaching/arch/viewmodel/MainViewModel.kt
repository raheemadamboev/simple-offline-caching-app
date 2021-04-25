package xyz.teamgravity.offlinecaching.arch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.teamgravity.offlinecaching.arch.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: MainRepository
) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()
}