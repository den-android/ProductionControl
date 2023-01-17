package net.denis.productioncontrol.features.stage_checklist.data.datasources.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "stage_table"
)
data class StageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(collate = ColumnInfo.NOCASE, name = "stage_name")
    val name: String,
)