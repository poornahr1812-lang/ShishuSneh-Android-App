package com.shishusneh.app.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface VaccineDao {

    @Insert
    suspend fun insertVaccine(vaccine: Vaccine)

    @Query("SELECT * FROM vaccines")
    suspend fun getAllVaccines(): List<Vaccine>

    @Delete
    suspend fun deleteVaccine(vaccine: Vaccine)
}