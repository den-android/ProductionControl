package net.denis.productioncontrol.data.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.NOCASE
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "checklist_table"
)

data class ChecklistEntity(

    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(collate = NOCASE, name = "checklist_name")
    val name: String

) : Serializable