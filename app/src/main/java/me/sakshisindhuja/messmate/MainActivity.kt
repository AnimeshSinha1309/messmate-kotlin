package me.sakshisindhuja.messmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

import me.sakshisindhuja.messmate.datamodels.TestDataModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = TestDataModel().loadMealPlans()

        val recyclerView = findViewById<RecyclerView>(R.id.meals_list_recycler_view)
        recyclerView.adapter = MealsListAdapter(this, myDataset)

    }
}