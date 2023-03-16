package com.ucne.roomexample.data.remote

import com.ucne.roomexample.data.remote.dto.OcupacionesDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TePrestoApi {
    @GET("/api/ocupaciones")
    suspend fun getOcupaciones(): List<OcupacionesDto>

    @POST("/api/Ocupaciones")
    suspend fun postOcupacion(@Body ocupacionesDto: OcupacionesDto): OcupacionesDto

    @PUT("/api/Ocupaciones/{id}")
    suspend fun putOcupacion(@Path("id") id: Int ,@Body ocupacionesDto: OcupacionesDto): Response<Unit>
    @DELETE("/api/Ocupaciones/{id}")
    suspend fun deleteOcupacion(@Path("id") id: Int)
}