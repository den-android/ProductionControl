package net.denis.productioncontrol.presentation.screen

import androidx.compose.runtime.Composable
import net.denis.productioncontrol.presentation.viewmodel.AssemblyStageViewModel

@Composable
fun AssemblyStageScreen(
    viewModel: AssemblyStageViewModel
) {
    val assemblyStageState = viewModel.stateAssemblyStage.value
    

}