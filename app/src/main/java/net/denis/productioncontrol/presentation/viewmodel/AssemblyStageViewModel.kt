package net.denis.productioncontrol.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import net.denis.productioncontrol.domain.model.AssemblyStage
import net.denis.productioncontrol.domain.repository.IAssemblyStageRepository
import net.denis.productioncontrol.presentation.state.AssemblyStageState
import net.denis.productioncontrol.util.Result
import javax.inject.Inject

@HiltViewModel
class AssemblyStageViewModel @Inject constructor(
    private val assemblyStageRepository: IAssemblyStageRepository
) : ViewModel() {

    private val _stateAssemblyStage = mutableStateOf(AssemblyStageState())
    val stateAssemblyStage: State<AssemblyStageState> = _stateAssemblyStage

    fun handleEvent(event: AssemblyStageContract.Event) {
        when (event) {
            is AssemblyStageContract.Event.FetchAssemblyStage -> {
                getAssemblyStage()
            }
            is AssemblyStageContract.Event.SaveAssemblyStage -> {
                val stage = event.stage
                saveAssemblyStage(stage)
            }
        }
    }

    private fun getAssemblyStage() {
        viewModelScope.launch {
            assemblyStageRepository.getAssemblyStage().onEach { result ->
                when (result) {
                    is Result.Success -> {
                        _stateAssemblyStage.value = _stateAssemblyStage.value.copy(
                            assemblyStageList = (result.data) ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Result.Error -> {
                        _stateAssemblyStage.value = _stateAssemblyStage.value.copy(
                            error = result.message?: "Произошла ошибка",
                            isLoading = false
                        )
                    }
                    is Result.Loading -> {
                        _stateAssemblyStage.value = _stateAssemblyStage.value.copy(
                            isLoading = true,
                        )
                    }
                }
            }
        }
    }

    private fun saveAssemblyStage(stage: AssemblyStage) {
        viewModelScope.launch(Dispatchers.IO) {
            assemblyStageRepository.saveAssemblyStage(stage)
        }
    }

}