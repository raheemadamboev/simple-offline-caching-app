package xyz.teamgravity.offlinecaching.arch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import xyz.teamgravity.offlinecaching.arch.repository.MainRepository
import xyz.teamgravity.offlinecaching.model.RestaurantModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _restaurants = MutableLiveData<List<RestaurantModel>>()
    val restaurants: LiveData<List<RestaurantModel>> = _restaurants

    init {
        viewModelScope.launch {
            val result = repository.getRestaurants()

            delay(2000)

            _restaurants.postValue(result)
        }
    }
}