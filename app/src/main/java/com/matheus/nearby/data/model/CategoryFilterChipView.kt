package com.matheus.nearby.data.model

import androidx.annotation.DrawableRes
import com.matheus.nearby.R

enum class CategoryFilterChipView(
    val description: String,
    @DrawableRes val icon: Int
) {
    FOOD(description = "Food", icon = R.drawable.ic_tools_kitchen_2),
    SHOPPING(description = "Shopping", icon = R.drawable.ic_shopping_bag),
    ACCOMMODATION(description = "Accommodation", icon = R.drawable.ic_bed),
    SUPERMARKET(description = "Supermarket", icon = R.drawable.ic_shopping_cart),
    ENTERTAINMENT(description = "Movies", icon = R.drawable.ic_movie),
    PHARMACY(description = "Pharmacy", icon = R.drawable.ic_first_aid_kit),
    FUEL(description = "Fuel", icon = R.drawable.ic_gas_station),
    BAKERY(description = "Bakery", icon = R.drawable.ic_bakery);


    companion object {
        fun fromDescription(description: String): CategoryFilterChipView? {
            return entries.find { it.description == description }
        }
    }
}