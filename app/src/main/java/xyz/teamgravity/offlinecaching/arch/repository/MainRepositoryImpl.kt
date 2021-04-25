package xyz.teamgravity.offlinecaching.arch.repository

import androidx.room.withTransaction
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.offlinecaching.arch.api.RandomDataApi
import xyz.teamgravity.offlinecaching.arch.database.RestaurantDatabase
import xyz.teamgravity.offlinecaching.helper.util.Resource
import xyz.teamgravity.offlinecaching.helper.util.networkBoundResource
import xyz.teamgravity.offlinecaching.model.RestaurantModel

class MainRepositoryImpl(
    private val api: RandomDataApi,
    private val db: RestaurantDatabase
) : MainRepository {

    private val dao = db.restaurantDao()

    override fun getRestaurants(): Flow<Resource<List<RestaurantModel>>> = networkBoundResource(
        query = {
            dao.getRestaurants()
        },
        fetch = {
            delay(2000)
            api.retrieveRestaurants()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                dao.deleteAll()
                dao.insertAll(restaurants)
            }
        }
    )
}