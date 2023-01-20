package net.denis.productioncontrol.features.stage_checklist.mvi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.denis.productioncontrol.features.stage_checklist.model.ChecklistItem
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

    fun fillChecklistItem(checklistItem: ChecklistItem) {
        viewModelScope.launch {
            stageStore.dispatch(StageAction.FillChecklistItem(checklistItem))
        }
    }
}