package me.sakshisindhuja.messmate.datamodels

import android.content.Context


class MealsDataInterface {

    private fun writeMealPlans(context: Context) {
        if (AppDatabase.getDatabase(context).mealsPlanDAO().getAll().isEmpty()) {
            val dummyData = listOf(
                MealsPlan(1, "Masala Dosa", "Breakfast 26/05", 120),
                MealsPlan(2, "Veg Biryani", "Lunch 26/05", 123),
                MealsPlan(3, "Paneer Roti", "Dinner 26/05", 124),
                MealsPlan(4, "Sambhar Vada", "Breakfast 27/05", 126),
                MealsPlan(5, "Puri Chola", "Lunch 27/05", 128),
                MealsPlan(6, "Bhindi Roti", "Dinner 27/05", 130),
                MealsPlan(7, "Idli", "Breakfast 28/05", 131),
                MealsPlan(8, "Fried Rice", "Lunch 28/05", 132),
                MealsPlan(9, "Lachcha Paratha", "Dinner 28/05", 135),
                MealsPlan(10, "Fruit Salad", "Breakfast 28/05", 136),
                MealsPlan(11, "Aalo, Aachar, Paratha", "Lunch 28/05", 137),
                MealsPlan(12, "Gobi Sabzi", "Dinner 28/05", 138),
                MealsPlan(13, "Poha", "Breakfast 28/05", 140),
                MealsPlan(14, "Tadka, Roti, Omlet", "Lunch 28/05", 145),
                MealsPlan(15, "Kaddu Roti", "Dinner 28/05", 151),
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
}