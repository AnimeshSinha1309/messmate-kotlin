package me.sakshisindhuja.messmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

import me.sakshisindhuja.messmate.datamodels.TestDataModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = TestDataModel().loadMealPlans()

        val recyclerView = findViewById<RecyclerView>(R.id.meals_list_recycler_view)
        recyclerView.adapter = MealsListAdapter(this, myDataset)

        val reportingActionButton = findViewById<FloatingActionButton>(R.id.report_action_button)
        reportingActionButton.setOnClickListener {
            val context = reportingActionButton.context
            val intent = Intent(context, ReportingActivity::class.java)
            intent.putExtra("currentDate", "26/05/2022")
            context.startActivity(intent)
        }
    }
}