package me.sakshisindhuja.messmate.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.sakshisindhuja.messmate.R

import me.sakshisindhuja.messmate.datamodels.ComplaintItem


/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
class ComplaintsListAdapter(
    private val dataset: List<ComplaintItem>
) : RecyclerView.Adapter<ComplaintsListAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textViewComplaintSummary: TextView = view.findViewById(R.id.text_complaint_summary)
        val textViewComplaintMeal: TextView = view.findViewById(R.id.text_complaint_meal)
        val textViewComplaintDate: TextView = view.findViewById(R.id.text_complaint_date)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.complaint_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textViewComplaintSummary.text = item.complaintSummary
        holder.textViewComplaintMeal.text = item.mealType
        holder.textViewComplaintDate.text = item.complaintDate
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}