package net.denis.productioncontrol.features.stage_checklist.data.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room.entities.CompletedChecklistEntity

@Dao
interface ICompletedChecklistDao {

    @Query("")
    suspend fun addChecklistAnswerItem(stageId: Int, status: Int, message: String?): CompletedChecklistEntity

    @Insert
    suspend fun addChecklist(completedChecklistEntity: CompletedChecklistEntity)

    @Delete
    suspend fun removeAllFromCompletedChecklist(completedChecklistEntity: CompletedChecklistEntity)
}