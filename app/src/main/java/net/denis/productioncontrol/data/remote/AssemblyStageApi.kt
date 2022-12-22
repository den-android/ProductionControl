package net.denis.productioncontrol.data.remote

import net.denis.productioncontrol.data.remote.dto.AssemblyStageDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface AssemblyStageApi {

    @GET("")
    @Headers("Content-type: application/json")
    suspend fun getAssemblyStage(): List<AssemblyStageDto>

}