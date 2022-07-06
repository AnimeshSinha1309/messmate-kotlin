package me.sakshisindhuja.messmate.datamodels

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ComplaintItem(
    @NonNull @ColumnInfo(name = "complaint_summary") val complaintSummary: String,
    @NonNull @ColumnInfo(name = "meal_type") val mealType: String,
    @PrimaryKey @NonNull @ColumnInfo(name = "complaint_date") val complaintDate: String,
    @NonNull @ColumnInfo(name = "emergency") val emergency: Boolean
)