package me.sakshisindhuja.messmate.datamodels

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class ComplaintItem(
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "complaint_summary") val mealName: String,
    @NonNull @ColumnInfo(name = "meal_type") val mealType: String,
    @NonNull @ColumnInfo(name = "complaint_date") val complaintDate: Date,
    @NonNull @ColumnInfo(name = "emergency") val emergency: Boolean
)