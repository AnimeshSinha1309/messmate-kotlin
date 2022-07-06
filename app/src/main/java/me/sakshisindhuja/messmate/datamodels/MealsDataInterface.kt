package me.sakshisindhuja.messmate.datamodels

import android.content.Context


class MealsDataInterface {

    private fun writeMealPlans(context: Context) {
        if (AppDatabase.getDatabase(context).mealsPlanDAO().getAll().isEmpty()) {
            val dummyData = listOf(
                MealsPlan(1, "Masala Dosa", "Breakfast", "26/05"),
                MealsPlan(2, "Veg Biryani", "Lunch", "26/05"),
                MealsPlan(3, "Paneer Roti", "Dinner", "26/05"),
                MealsPlan(4, "Sambhar Vada", "Breakfast","27/05"),
                MealsPlan(5, "Puri Chola", "Lunch", "27/05"),
                MealsPlan(6, "Bhindi Roti", "Dinner","27/05"),
                MealsPlan(7, "Idli", "Breakfast", "28/05"),
                MealsPlan(8, "Fried Rice", "Lunch", "28/05"),
                MealsPlan(9, "Lachcha Paratha", "Dinner","28/05"),
                MealsPlan(10, "Fruit Salad", "Breakfast", "29/05"),
                MealsPlan(11, "Aalo, Aachar, Paratha", "Lunch","29/05"),
                MealsPlan(12, "Gobi Sabzi", "Dinner", "29/05"),
                MealsPlan(13, "Poha", "Breakfast", "30/05"),
                MealsPlan(14, "Tadka, Roti, Omlet", "Lunch", "30/05"),
                MealsPlan(15, "Kaddu Roti", "Dinner", "30/05"),
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

    fun loadMealsForToday(context: Context): List<MealsPlan> {
        writeMealPlans(context)
        return AppDatabase.getDatabase(context).mealsPlanDAO().getByMealDate("27/05")
        // TODO: Use current date string for this
    }
}