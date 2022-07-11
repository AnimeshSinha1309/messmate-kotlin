package me.sakshisindhuja.messmate.datamodels

import android.content.Context
import androidx.room.*

/**
 * Defines a database and specifies data tables that will be used.
 * Version is incremented as new tables/columns are added/removed/changed.
 * You can optionally use this class for one-time setup, such as pre-populating a database.
 */
@Database(entities = [MealsPlan::class, ComplaintItem::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun mealsPlanDAO(): MealsPlanDAO
    abstract fun complaintItemDAO(): ComplaintItemDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "messmate_database_3")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}
