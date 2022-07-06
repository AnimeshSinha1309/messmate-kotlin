package me.sakshisindhuja.messmate.datamodels

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert

/**
 * Provides access to read/write operations on the schedule table.
 * Used by the view models to format the query results for use in the UI.
 */
@Dao
interface MealsPlanDAO {
    @Query("SELECT * FROM MealsPlan ORDER BY meal_date_id ASC")
    fun getAll(): List<MealsPlan>

    @Query("SELECT * FROM MealsPlan WHERE meal_type = :mealType ORDER BY meal_date_id ASC")
    fun getByMealType(mealType: String): List<MealsPlan>

    @Query("SELECT * FROM MealsPlan WHERE meal_name = :mealName ORDER BY meal_date_id ASC")
    fun getByMealName(mealName: String): List<MealsPlan>

    @Insert
    fun insert(vararg mealPlan: MealsPlan)

    @Delete
    fun delete(mealPlan: MealsPlan)
}
