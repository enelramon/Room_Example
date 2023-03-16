package com.ucne.roomexample.data.repository

import com.ucne.roomexample.data.remote.dto.OcupacionesDto
import com.ucne.roomexample.util.Resource
import kotlinx.coroutines.flow.Flow

interface Ocupaciones2Repository {
    fun getOcupaciones(): Flow<Resource<List<OcupacionesDto>>>
    suspend fun putOcupacion(id: Int, ocupacionesDto: OcupacionesDto)

    suspend fun deleteOcupacion(id: Int)
}

