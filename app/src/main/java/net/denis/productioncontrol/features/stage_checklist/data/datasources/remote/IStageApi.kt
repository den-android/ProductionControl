package net.denis.productioncontrol.features.stage_checklist.data.datasources.remote

import net.denis.productioncontrol.features.stage_checklist.data.datasources.remote.dto.StageDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface IStageApi {

    @GET("")
    @Headers("Content-type: application/json")
    suspend fun getStage(): Response<List<StageDto>>

}