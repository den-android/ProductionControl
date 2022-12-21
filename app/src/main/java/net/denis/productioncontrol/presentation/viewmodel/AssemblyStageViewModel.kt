package net.denis.productioncontrol.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import net.denis.productioncontrol.domain.repository.IAssemblyStageRepository
import net.denis.productioncontrol.util.Result
import javax.inject.Inject

@HiltViewModel
class AssemblyStageViewModel @Inject constructor(
    private val assemblyStageRepository: IAssemblyStageRepository
) : ViewModel() {

    fun createInitialState(): AssemblyStageContract.State {
        return AssemblyStageContract.State(
            assemblyStageState = AssemblyStageContract.AssemblyStageState.Idle,
        )
    }

    fun handleEvent(event: AssemblyStageContract.Event) {
        when (event) {
            is AssemblyStageContract.Event.FetchAssemblyStage -> {
                fetchAssemblyStage()
            }
            is AssemblyStageContract.Event.OnStageClicked -> {
               TODO()
            }
        }
    }

    private fun fetchAssemblyStage() {
        viewModelScope.launch {
            assemblyStageRepository.getAssemblyStage()
                .onStart { emit(Result.Loading) }
                .collect {
                    when (it) {
                        is Result.Loading -> {

                        }
                    }
                }
        }
    }
    
}