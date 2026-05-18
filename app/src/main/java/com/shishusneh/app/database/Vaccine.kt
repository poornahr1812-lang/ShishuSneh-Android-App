package com.shishusneh.app.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vaccines")
data class Vaccine(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val vaccineName: String,
    val vaccineDate: String
)