package com.ucne.roomexample.data.repository

import com.ucne.roomexample.data.remote.TePrestoApi
import com.ucne.roomexample.data.remote.dto.OcupacionesDto
import com.ucne.roomexample.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class Ocupaciones2RepositoryImp @Inject constructor(
    private val api: TePrestoApi
): Ocupaciones2Repository {

    override fun getOcupaciones(): Flow<Resource<List<OcupacionesDto>>> = flow {
        try {
            emit(Resource.Loading()) //indicar que estamos cargando

            val ocupaciones =
                api.getOcupaciones() //descarga las ocupaciones de internet, se supone quedemora algo

            emit(Resource.Success(ocupaciones)) //indicar que se cargo correctamente y pasarle las monedas
        } catch (e: HttpException) {
            //error general HTTP
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            //debe verificar tu conexion a internet
            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

    override suspend fun putOcupacion(id: Int, ocupacionesDto: OcupacionesDto) {
        api.putOcupacion(id,ocupacionesDto)
    }

    override suspend fun deleteOcupacion(id: Int) = api.deleteOcupacion(id)
}