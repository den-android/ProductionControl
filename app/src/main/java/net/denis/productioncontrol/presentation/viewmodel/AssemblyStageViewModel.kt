package net.denis.productioncontrol.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import net.denis.productioncontrol.domain.repository.IStageRepository
import net.denis.productioncontrol.presentation.base.BaseViewModel
import net.denis.productioncontrol.presentation.state.*
import net.denis.productioncontrol.util.Result
import javax.inject.Inject

@HiltViewModel
class AssemblyStageViewModel @Inject constructor(
    private val stageRepository: IStageRepository
) : BaseViewModel<ScreenContract.Event, ScreenContract.State, ScreenContract.Effect>() {
    
    override fun createInitialState(): ScreenContract.State {
        TODO("Not yet implemented")
    }

    override fun handleEvent(event: ScreenContract.Event) {
        TODO("Not yet implemented")
    }

    //    private val _stateAssemblyStage = mutableStateOf(AssemblyStageStates())
//    val stateAssemblyStage: State<AssemblyStageStates> = _stateAssemblyStage



    //    fun handleEvent(action: AssemblyStageContract.Action) {
//        when (action) {
//            is AssemblyStageContract.Action.LoadAssemblyStage -> {
//                getAssemblyStage()
//            }
//            is AssemblyStageContract.Action.SaveAssemblyStage -> {
//                val stage = action.assemblyStage
//                saveAssemblyStage(stage)
//            }
//        }
//    }
//    protected fun setState(reduce: State.() -> State) {
//        val newState = currentState.reduce()
//        _uiState.value = newState
//    }
//
//    private fun getAssemblyStage() {
//        viewModelScope.launch {
//            stageRepository.getStage()
//                .onStart { emit(Result.Loading()) }
//                .collect { result ->
//                    when (result) {
//                        is Result.Success -> {
//                            _stateAssemblyStage.value = _stateAssemblyStage.value.copy(
//                                assemblyStageList = (result.data) ?: emptyList(),
//                                isLoading = false
//                            )
//                        }
//                        is Result.Error -> {
//                            _stateAssemblyStage.value = _stateAssemblyStage.value.copy(
//                                error = result.message ?: "Произошла ошибка",
//                                isLoading = false
//                            )
//                        }
//                        is Result.Loading -> {
//                            _stateAssemblyStage.value = _stateAssemblyStage.value.copy(
//                                isLoading = true,
//                            )
//                        }
//                    }
//                }
//        }
//    }

//    private fun saveAssemblyStage(stage: AssemblyStage) {
//        viewModelScope.launch(Dispatchers.IO) {
//            assemblyStageRepository.saveAssemblyStage(stage)
//        }
//    }

}