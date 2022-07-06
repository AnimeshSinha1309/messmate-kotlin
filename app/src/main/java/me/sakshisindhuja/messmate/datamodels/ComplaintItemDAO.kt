package me.sakshisindhuja.messmate.datamodels

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert

/**
 * Provides access to read/write operations on the schedule table.
 * Used by the view models to format the query results for use in the UI.
 */
@Dao
interface ComplaintItemDAO {
    @Query("SELECT * FROM ComplaintItem ORDER BY complaint_date DESC")
    fun getAll(): List<ComplaintItem>

    @Insert
    fun insert(vararg complaintItem: ComplaintItem)
}
