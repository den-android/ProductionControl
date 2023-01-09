package net.denis.productioncontrol.presentation.screen.stage_screen.state

import net.denis.productioncontrol.presentation.model.Stage

data class StageState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val stageList: List<Stage> = emptyList()
)