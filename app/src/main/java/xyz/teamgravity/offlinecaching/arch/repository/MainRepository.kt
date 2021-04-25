package xyz.teamgravity.offlinecaching.arch.repository

import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.offlinecaching.helper.util.Resource
import xyz.teamgravity.offlinecaching.model.RestaurantModel

interface MainRepository {

    fun getRestaurants(): Flow<Resource<List<RestaurantModel>>>
}