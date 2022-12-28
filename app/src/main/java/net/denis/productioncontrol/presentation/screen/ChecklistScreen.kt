package net.denis.productioncontrol.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.denis.productioncontrol.data.remote.dto.StageDto
import net.denis.productioncontrol.domain.model.Checklist
import net.denis.productioncontrol.presentation.screen.components.ChecklistCardItem
import net.denis.productioncontrol.presentation.state.StageContract
import net.denis.productioncontrol.presentation.viewmodel.StageViewModel

@Composable
fun ChecklistScreen(
    vm: StageViewModel,
    stageId: Int,
) {
    val state = vm.viewState.value

    LazyColumn {
        items(state.stageList) { item ->
            item.checklist.forEachIndexed() { index, checklist ->
                Text(text = "${checklist.name}   $stageId")
            }
        }
    }

//  val checklist = Checklist(0, "Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text v")
//
//    ChecklistCardItem(
//        checklist = checklist,
//        loadNextChecklistItem = {
//        }
//    )

}
