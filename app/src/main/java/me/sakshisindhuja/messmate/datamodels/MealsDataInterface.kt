package me.sakshisindhuja.messmate.datamodels

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MealsDataInterface {

    private fun writeMealPlans(context: Context) {
        if (AppDatabase.getDatabase(context).mealsPlanDAO().getAll().isEmpty()) {
            val dummyData = listOf(
                MealsPlan(1, "Masala Dosa", "Breakfast", "07/07/22"),
                MealsPlan(2, "Veg Biryani", "Lunch", "07/07/22"),
                MealsPlan(3, "Paneer Roti", "Dinner", "07/07/22"),
                MealsPlan(4, "Sambhar Vada", "Breakfast","08/07/22"),
                MealsPlan(5, "Puri Chola", "Lunch", "08/07/22"),
                MealsPlan(6, "Bhindi Roti", "Dinner","08/07/22"),
                MealsPlan(7, "Idli", "Breakfast", "09/07/22"),
                MealsPlan(8, "Fried Rice", "Lunch", "09/07/22"),
                MealsPlan(9, "Lachcha Paratha", "Dinner","09/07/22"),
                MealsPlan(10, "Fruit Salad", "Breakfast", "10/07/22"),
                MealsPlan(11, "Aalo, Aachar, Paratha", "Lunch","10/07/22"),
                MealsPlan(12, "Gobi Sabzi", "Dinner", "10/07/22"),
                MealsPlan(13, "Poha", "Breakfast", "11/07/22"),
                MealsPlan(14, "Tadka, Roti, Omlet", "Lunch", "11/07/22"),
                MealsPlan(15, "Kaddu Roti", "Dinner", "11/07/22"),
            )
            for (dummyItem in dummyData) {
                AppDatabase.getDatabase(context).mealsPlanDAO().insert(
                    dummyItem,
                )
            }
        }
    }

    fun loadMealPlans(context: Context): List<MealsPlan> {
        writeMealPlans(context)
        return AppDatabase.getDatabase(context).mealsPlanDAO().getAll()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadMealsForToday(context: Context): List<MealsPlan> {
        writeMealPlans(context)
        val today: String = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("dd/MM/yy"))
        return AppDatabase.getDatabase(context).mealsPlanDAO().getByMealDate(today)
        // TODO: Use current date string for this
    }
}