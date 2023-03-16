package com.ucne.roomexample.data.repository

import androidx.lifecycle.ViewModel
import com.ucne.roomexample.data.local.dao.OcupacionDao
import com.ucne.roomexample.data.local.entity.OcupacionEntity
import com.ucne.roomexample.data.local.entity.toOcupacionDto
import com.ucne.roomexample.data.remote.TePrestoApi
import com.ucne.roomexample.data.remote.dto.OcupacionesDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OcupacionRepository @Inject constructor(
    private  val ocupacionDao: OcupacionDao,
    private  val tePrestoApi: TePrestoApi
) {
    suspend fun insert(ocupacion: OcupacionEntity) {

         ocupacionDao.insert(ocupacion) //insertar en la base de datos

        val ocupacionesNoEnviadas = ocupacionDao.getNoEnviadas() //buscar no enviados

        //tePrestoApi.postOcupacion(ocupacion.toOcupacionDto())

        tePrestoApi.putOcupacion(ocupacion.ocupacionId!! ,ocupacion.toOcupacionDto())

    /*    ocupacionesNoEnviadas.map { ocupacionEntity ->
            val dto = ocupacionEntity.toOcupacionDto()
            tePrestoApi.postOcupacion(dto)
        }*/

    }
    suspend fun delete(ocupacion: OcupacionEntity) = ocupacionDao.delete(ocupacion)

    suspend fun find(ocupacionId:Int) = ocupacionDao.find(ocupacionId)
    suspend fun putOcupacion(id: Int, ocupacionesDto: OcupacionesDto) = tePrestoApi.putOcupacion(id,ocupacionesDto)

    fun getList(): Flow<List<OcupacionEntity>> = ocupacionDao.getList()

}

