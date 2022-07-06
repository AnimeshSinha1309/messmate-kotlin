package me.sakshisindhuja.messmate.datamodels

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MealsPlan(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "meal_name") val mealName: String,
    @NonNull @ColumnInfo(name = "meal_type") val mealType: String,
    @NonNull @ColumnInfo(name = "meal_date_id") val mealDateId: String,
)