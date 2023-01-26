package com.ucne.roomexample.data.local.dao

import androidx.room.*
import com.ucne.roomexample.data.local.entity.OcupacionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OcupacionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ocupacionEntity: OcupacionEntity)

    @Delete
    suspend fun delete(ocupacionEntity: OcupacionEntity)

    @Query("""
        SELECT * 
        FROM Ocupaciones
        WHERE OcupacionId=:ocupacionId
        LIMIT 1
    """)
    suspend fun find(ocupacionId: Int): OcupacionEntity?

    @Query("SELECT * FROM Ocupaciones")
    fun getList(): Flow<List<OcupacionEntity>>

}

class dao{
    fun save():Boolean{
        return true
    }
}