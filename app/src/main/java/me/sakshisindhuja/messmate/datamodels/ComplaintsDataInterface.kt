package me.sakshisindhuja.messmate.datamodels

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class ComplaintsDataInterface {

    @RequiresApi(Build.VERSION_CODES.O)
    fun writeComplaint(context: Context, summary: String, mealType: String, emergency: Boolean) {
        val complaintItem = ComplaintItem(
            complaintSummary = summary,
            mealType = mealType,
            complaintDate = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")),
            emergency = emergency
        )
        AppDatabase.getDatabase(context).complaintItemDAO().insert(complaintItem)
    }

    fun loadComplaints(context: Context): List<ComplaintItem> {
        return AppDatabase.getDatabase(context).complaintItemDAO().getAll();
    }
}