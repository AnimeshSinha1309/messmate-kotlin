package me.sakshisindhuja.messmate.datamodels

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Provides access to read/write operations on the schedule table.
 * Used by the view models to format the query results for use in the UI.
 */
@Dao
interface MealsPlanDAO {
    @Query("SELECT * FROM MealsPlan ORDER BY meal_date_id ASC")
    fun getAll(): Flow<List<MealsPlan>>

    @Query("SELECT * FROM MealsPlan WHERE meal_type = :mealType ORDER BY meal_date_id ASC")
    fun getByMealType(mealType: String): Flow<List<MealsPlan>>

    @Query("SELECT * FROM MealsPlan WHERE meal_name = :mealName ORDER BY meal_date_id ASC")
    fun getByMealName(mealName: String): Flow<List<MealsPlan>>
}
