package net.denis.productioncontrol.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import net.denis.productioncontrol.presentation.state.CarState
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor(

) : ViewModel() {

    private val _stateCarList = mutableStateOf(CarState())
    val stateCarList: State<CarState> = _stateCarList
//
//    private fun handleIntent() {
//        viewModelScope.launch(Dispatchers.IO) {
//            userIntent.consumeAsFlow().collect {
//                when (it) {
//                    is MainIntent.FetchCar -> fetchCar()
//                }
//            }
//        }
//    }
//
//    private fun fetchCar() {
//        viewModelScope.launch(Dispatchers.IO) {
//            _stateCarList.value = CarState(isLoading = true)
//
//
//        }
//    }
//
//    init {
//        handleIntent()
//    }

}
//_stateCarList.value = CarListState(cars = (carItem) ?: emptyList())
/*
    private fun loadCars() {
        viewModelScope.launch(Dispatchers.IO) {
            _stateCarList.value = _stateCarList.value.copy(
                isLoading = true,
                error = null
            )

            carListRepository.getCarList().let {
                when (Result.Success) {

                }
            }
        }
    }
 */

/*
//    private val _state = MutableStateFlow<AssemblyStageState>(AssemblyStageState.Idle)
//    val state: StateFlow<AssemblyStageState>
//        get() = _state
 */