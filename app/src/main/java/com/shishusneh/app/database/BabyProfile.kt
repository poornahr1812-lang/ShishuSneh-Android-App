package com.shishusneh.app.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "baby_profile")
data class BabyProfile(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val babyName: String,
    val dateOfBirth: String,
    val gender: String,
    val birthWeight: String,
    val motherContact: String
)
