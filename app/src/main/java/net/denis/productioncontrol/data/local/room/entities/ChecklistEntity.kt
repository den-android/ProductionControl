package net.denis.productioncontrol.data.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.NOCASE
import androidx.room.Entity
import java.io.Serializable

@Entity(
    tableName = "checklist_table"
)

data class ChecklistEntity(
    /**
     *  Расширить модель
     */
    @ColumnInfo(collate = NOCASE, name = "purchase_sale_agreement")
    val PurchaseSaleAgreement: String,

    ): Serializable