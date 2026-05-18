package com.shishusneh.app.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "growth_entries")
data class GrowthEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val month: Float,
    val weight: Float
)
