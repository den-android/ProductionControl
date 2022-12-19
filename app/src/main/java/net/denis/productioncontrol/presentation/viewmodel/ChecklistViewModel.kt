package net.denis.productioncontrol.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import net.denis.productioncontrol.presentation.state.ChecklistState
import javax.inject.Inject

@HiltViewModel
class ChecklistViewModel @Inject constructor(

): ViewModel() {

    private val _stateChecklist = mutableStateOf(ChecklistState())
    val stateChecklist: State<ChecklistState> = _stateChecklist

}