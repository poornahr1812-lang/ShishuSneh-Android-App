package com.shishusneh.app.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BabyProfileDao {

    @Insert
    suspend fun insertProfile(profile: BabyProfile)

    @Query("SELECT * FROM baby_profile LIMIT 1")
    suspend fun getProfile(): BabyProfile?
}