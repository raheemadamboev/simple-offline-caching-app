package xyz.teamgravity.offlinecaching.model

import com.google.gson.annotations.SerializedName

data class RestaurantModel(

    @SerializedName("name")
    val name: String = "",

    @SerializedName("type")
    val type: String = "",

    @SerializedName("logo")
    val logo: String = "",

    @SerializedName("address")
    val address: String = ""
)
