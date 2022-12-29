package net.denis.productioncontrol.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import net.denis.productioncontrol.domain.repository.IStageRepository
import net.denis.productioncontrol.presentation.base.BaseViewModel
import net.denis.productioncontrol.presentation.base.ViewState
import net.denis.productioncontrol.presentation.state.*
import net.denis.productioncontrol.util.Result
import javax.inject.Inject

@HiltViewModel
class StageViewModel @Inject constructor(
    private val stageRepository: IStageRepository
) : BaseViewModel<StageContract.Event, StageContract.State, StageContract.Effect>() {

    override fun setInitialState() =
        StageContract.State(stageList = emptyList(), isLoading = true)


    override fun handleEvent(event: StageContract.Event) {
        when (event) {
            is StageContract.Event.OnFetchStage -> {
                fetchStage()
            }
            is StageContract.Event.OnFetchChecklist -> {
                fetchChecklist()
            }
            is StageContract.Event.LoadNextChecklistItem -> {
                loadNextChecklistItem()
            }
        }
    }

    private fun fetchStage() {
        viewModelScope.launch {
            stageRepository.getStage()
                .collect { result ->
                    when (result) {
                        is Result.Loading -> {
                            setState {
                                copy(
                                    isLoading = isLoading,
                                )
                            }
                        }
                        is Result.Success -> {
                            val data = result.data ?: emptyList()
                            setState {
                                copy(
                                    stageList = data,
                                    isLoading = false,
                                )
                            }
                        }
                        is Result.Error -> {
                            setState {
                                copy(
                                    error = result.message,
                                    isLoading = false,
                                )
                            }
                        }
                    }
                }
        }
    }

    private fun fetchChecklist() {
        Log.d("----", "///LOAD CHECKLIST")
    }

    private fun loadNextChecklistItem() {

    }

    init {
        viewModelScope.launch {
            handleEvent(event = StageContract.Event.OnFetchStage)
        }
    }
}
//) : BaseViewModel<StageContract.Event, StageContract.State, StageContract.Effect>() {
//
//    private val _viewState: MutableStateFlow<StageContract.State> = MutableStateFlow(StageContract.State())
//    val viewState = _viewState.asStateFlow()
//
//    private fun handleEvent(event: StageContract.Event) {
//        when (event) {
//            is StageContract.Event.OnFetchPosts -> {
//                fetchStage()
//            }
//            is StageContract.Event.OnSaveStage -> {
//                saveStage()
//            }
//        }
//    }
//

//

//
//    private val _event : MutableSharedFlow<StageContract.Event> = MutableSharedFlow()
//
//    init {
//        subscribeToEvents()
//    }
//
//    private fun subscribeToEvents() {
//        viewModelScope.launch {
//            _event.collect {
//                handleEvent(it)
//            }
//        }
//    }
//
//}

//
//    init {
//        viewModelScope.launch {  }
//    }

//    override fun setInitialState() = StageContract.State(
//        stageList = emptyList(),
//        isLoading = true
//    )
//
//    override fun handleEvent(event: StageContract.Event) {
//        when (event) {
//            is StageContract.Event.OnFetchPosts -> {
//                fetchStage()
//            }
//        }
//    }

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

//    private fun saveAssemblyStage(stage: AssemblyStage) {
//        viewModelScope.launch(Dispatchers.IO) {
//            assemblyStageRepository.saveAssemblyStage(stage)
//        }
//    }

//}