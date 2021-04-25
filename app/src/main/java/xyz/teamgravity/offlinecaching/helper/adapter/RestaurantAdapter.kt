package xyz.teamgravity.offlinecaching.helper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import xyz.teamgravity.offlinecaching.databinding.CardRestaurantBinding
import xyz.teamgravity.offlinecaching.model.RestaurantModel

class RestaurantAdapter : ListAdapter<RestaurantModel, RestaurantAdapter.RestaurantViewHolder>(DIFF) {
    companion object {
       private val DIFF = object : DiffUtil.ItemCallback<RestaurantModel>() {
            override fun areItemsTheSame(oldItem: RestaurantModel, newItem: RestaurantModel) =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: RestaurantModel, newItem: RestaurantModel) =
                oldItem == newItem
        }
    }

    class RestaurantViewHolder(private val binding: CardRestaurantBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: RestaurantModel) {
            binding.apply {
                Glide.with(root)
                    .load(model.logo)
                    .centerCrop()
                    .into(imageI)

                nameT.text = model.name
                typeT.text = model.type
                addressT.text = model.address
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(CardRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}