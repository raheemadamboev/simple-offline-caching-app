package xyz.teamgravity.offlinecaching.arch.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.offlinecaching.helper.const.DatabaseConst
import xyz.teamgravity.offlinecaching.model.RestaurantModel

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(restaurants: List<RestaurantModel>)

    @Query("DELETE FROM ${DatabaseConst.RESTAURANT_TABLE}")
    suspend fun deleteAll()

    @Query("SELECT * FROM ${DatabaseConst.RESTAURANT_TABLE}")
    fun getRestaurants(): Flow<List<RestaurantModel>>
}