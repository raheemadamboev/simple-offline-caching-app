package xyz.teamgravity.offlinecaching.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import xyz.teamgravity.offlinecaching.helper.const.DatabaseConst

@Entity(tableName = DatabaseConst.RESTAURANT_TABLE)
data class RestaurantModel(

    @PrimaryKey(autoGenerate = false)
    @SerializedName("name")
    val name: String = "",

    @SerializedName("type")
    val type: String = "",

    @SerializedName("logo")
    val logo: String = "",

    @SerializedName("address")
    val address: String = ""
)
