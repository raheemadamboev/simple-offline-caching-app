package xyz.teamgravity.offlinecaching.arch.api

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import xyz.teamgravity.offlinecaching.model.RestaurantModel

interface RandomDataApi {
    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
        const val DEFAULT_SIZE = 20
    }

    @GET("restaurant/random_restaurant")
    suspend fun retrieveRestaurants(@Query("size") size: Int = DEFAULT_SIZE): List<RestaurantModel>

}