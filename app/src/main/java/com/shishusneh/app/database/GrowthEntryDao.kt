package com.shishusneh.app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GrowthEntryDao {

    @Insert
    suspend fun insertGrowth(entry: GrowthEntry)

    @Query("SELECT * FROM growth_entries")
    suspend fun getAllGrowth(): List<GrowthEntry>
}