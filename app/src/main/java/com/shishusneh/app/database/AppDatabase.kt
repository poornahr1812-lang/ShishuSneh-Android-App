package com.shishusneh.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [BabyProfile::class, GrowthEntry::class, Vaccine::class],
    version = 3
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun babyProfileDao(): BabyProfileDao
    abstract fun growthEntryDao(): GrowthEntryDao
    abstract fun vaccineDao(): VaccineDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "shishusneh_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}