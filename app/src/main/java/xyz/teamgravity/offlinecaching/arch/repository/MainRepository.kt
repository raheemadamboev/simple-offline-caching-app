package xyz.teamgravity.offlinecaching.arch.repository

import xyz.teamgravity.offlinecaching.model.RestaurantModel

interface MainRepository {

    suspend fun getRestaurants(): List<RestaurantModel>
}