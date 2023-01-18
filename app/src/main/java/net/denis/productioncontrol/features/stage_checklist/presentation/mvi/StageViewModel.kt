package net.denis.productioncontrol.features.stage_checklist.presentation.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StageViewModel @Inject constructor(
    private val stageStore: StageStore,
) : ViewModel() {

    val viewState: StateFlow<StageState> = stageStore.state

    init {
        stageStartLoad()
    }

    private fun stageStartLoad() {
        viewModelScope.launch {
            stageStore.dispatch(StageAction.StageLoading)
        }
    }

    fun sendChecklistResults(
        stageId: Int,
        checklistItemId: Int,
        statusCode: Int,
        message: String?
    ) {
        viewModelScope.launch {
            stageStore.dispatch(
                StageAction.SendChecklistItems(
                    stageId,
                    checklistItemId,
                    statusCode,
                    message
                )
            )
        }
    }
}