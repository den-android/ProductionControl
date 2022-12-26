package net.denis.productioncontrol.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.denis.productioncontrol.presentation.screen.components.CardItem
import net.denis.productioncontrol.presentation.viewmodel.AssemblyStageViewModel

@Composable
fun AssemblyStageScreen(
    viewModel: AssemblyStageViewModel
) {
    val state = viewModel.stateAssemblyStage.value



    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.assemblyStageList) { stage ->
            CardItem(
                stage = stage
            )
        }

    }

}