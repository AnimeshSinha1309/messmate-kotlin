package me.sakshisindhuja.messmate.datamodels

import me.sakshisindhuja.messmate.datamodels.MealsPlan

class TestDataModel {

    fun loadMealPlans(): List<MealsPlan> {
        return listOf<MealsPlan>(
            MealsPlan(1, "Masala Dosa", "Breakfast", 120),
            MealsPlan(1, "Veg Biryani", "Lunch", 123),
            MealsPlan(1, "Paneer Roti", "Dinner", 124),
            MealsPlan(1, "Sambhar Vada", "Breakfast", 126),
            MealsPlan(1, "Puri Chola", "Lunch", 128),
            MealsPlan(1, "Bhindi Roti", "Dinner", 130),
            MealsPlan(1, "Idli", "Breakfast", 131),
            MealsPlan(1, "Fried Rice", "Lunch", 132),
            MealsPlan(1, "Lachcha Paratha", "Dinner", 135),
        )
    }
}