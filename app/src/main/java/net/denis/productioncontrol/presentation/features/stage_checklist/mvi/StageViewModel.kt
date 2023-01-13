package net.denis.productioncontrol.presentation.features.stage_checklist.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StageViewModel @Inject constructor(
    private val stageStore: StageStore
) : ViewModel() {

    val viewState: StateFlow<StageViewState> = stageStore.state

    init {
        stageStartLoad()
    }

    private fun stageStartLoad() {
        viewModelScope.launch {
            stageStore.dispatch(StageAction.StageLoading)
        }
    }

    fun loadNextChecklist(currentId: Int) {
        viewModelScope.launch {
            stageStore.dispatch(StageAction.ChecklistLoading(currentId))
        }
    }
}