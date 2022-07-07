package me.sakshisindhuja.messmate.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.sakshisindhuja.messmate.R

import me.sakshisindhuja.messmate.datamodels.MealsPlan


/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
class MealsListAdapter(
    private val dataset: List<MealsPlan>
) : RecyclerView.Adapter<MealsListAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textViewMealItem: TextView = view.findViewById(R.id.text_meal_item_name)
        val textViewMealType: TextView = view.findViewById(R.id.text_meal_type_name)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.meal_plan_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        val mealType: String = item.mealType + " " + item.mealDateId
        holder.textViewMealItem.text = item.mealName
        holder.textViewMealType.text = mealType
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}