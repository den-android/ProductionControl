package net.denis.productioncontrol.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.denis.productioncontrol.presentation.screen.components.CarCardItem
import net.denis.productioncontrol.presentation.viewmodel.CarListViewModel

@Composable
fun CarListScreen(
    vm: CarListViewModel
) {
    val state = vm.stateCarList.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(state.cars) { car ->
                CarCardItem(
                    car = car
                )
            }
        }
    }
}