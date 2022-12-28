package net.denis.productioncontrol.data.remote

import net.denis.productioncontrol.data.remote.dto.StageDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface StageApi {

    @GET("")
    @Headers("Content-type: application/json")
    suspend fun getStage(): Response<List<StageDto>>

}