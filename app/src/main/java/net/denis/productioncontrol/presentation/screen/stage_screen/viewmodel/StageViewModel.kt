package net.denis.productioncontrol.presentation.screen.stage_screen.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.denis.productioncontrol.data.interfaces.IStageRepository
import net.denis.productioncontrol.presentation.base.BaseViewModel
import net.denis.productioncontrol.presentation.screen.stage_screen.state.StageState
import net.denis.productioncontrol.util.Result
import javax.inject.Inject

@HiltViewModel
class StageViewModel @Inject constructor(
    private val stageRepository: IStageRepository
) : BaseViewModel<StageContract.Event, StageContract.State>() {

    override fun setInitialState() =
        StageContract.State(
            stageState = StageState(
                isLoading = true,
                stageList = emptyList(),
            ),
        )

    override fun handleEvent(event: StageContract.Event) {
        when (event) {
            is StageContract.Event.FetchStage -> {
                fetchStage()
            }
            is StageContract.Event.FetchChecklist -> {

            }
            is StageContract.Event.LoadNextItem -> {

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
                                    stageState = stageState.copy(
                                        isLoading = true
                                    )
                                )
                            }
                        }
                        is Result.Success -> {
                            val data = result.data ?: emptyList()
                            setState {
                                copy(
                                    stageState = stageState.copy(
                                        stageList = data,
                                        isLoading = false,
                                    )
                                )
                            }
                        }
                        is Result.Error -> {
                            setState {
                                copy(
                                    stageState = stageState.copy(
                                        error = result.message,
                                        isLoading = false,
                                    )
                                )
                            }
                        }
                    }
                }
        }
    }

    init {
        viewModelScope.launch {
            handleEvent(event = StageContract.Event.FetchStage)
        }
    }
}

//
//    private fun getStatus(status: String, stageId: Int, currentChecklistId: Int) {
//        Log.d("----", "ViewModel// load next checklist item...")
//        when (status) {
//            "Green" -> {
//
//            }
//            "Yellow" -> {
//
//            }
//            "Red" -> {
//
//            }
//        }
//    }

//    private fun loadNextItem(currentChecklistId: Int) {
//        setState {
//            copy(
//                stageList = stageList
//            )
//        }
//    }

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