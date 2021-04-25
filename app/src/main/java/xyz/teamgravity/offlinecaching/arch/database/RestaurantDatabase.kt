package xyz.teamgravity.offlinecaching.arch.database

import androidx.room.Database
import androidx.room.RoomDatabase
import xyz.teamgravity.offlinecaching.helper.const.DatabaseConst
import xyz.teamgravity.offlinecaching.model.RestaurantModel

@Database(entities = [RestaurantModel::class], version = DatabaseConst.DATABASE_VERSION)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}