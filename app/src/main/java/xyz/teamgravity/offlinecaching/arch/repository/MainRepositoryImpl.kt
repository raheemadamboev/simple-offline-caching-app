package xyz.teamgravity.offlinecaching.arch.repository

import xyz.teamgravity.offlinecaching.arch.api.RandomDataApi
import xyz.teamgravity.offlinecaching.model.RestaurantModel

class MainRepositoryImpl(
    private val api: RandomDataApi
) : MainRepository {

    override suspend fun getRestaurants(): List<RestaurantModel> = api.retrieveRestaurants()
}