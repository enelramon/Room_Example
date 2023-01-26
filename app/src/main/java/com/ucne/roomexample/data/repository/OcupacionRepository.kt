package com.ucne.roomexample.data.repository

import com.ucne.roomexample.data.local.dao.OcupacionDao
import com.ucne.roomexample.data.local.entity.OcupacionEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OcupacionRepository @Inject constructor(
    private  val ocupacionDao: OcupacionDao
) {
    suspend fun insert(ocupacion: OcupacionEntity) {
        return ocupacionDao.insert(ocupacion)
    }
    suspend fun delete(ocupacion: OcupacionEntity) = ocupacionDao.delete(ocupacion)

    suspend fun find(ocupacionId:Int) = ocupacionDao.find(ocupacionId)

    fun getList(): Flow<List<OcupacionEntity>> = ocupacionDao.getList()
}