package net.denis.productioncontrol.presentation.screen.components

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.denis.productioncontrol.presentation.state.StageContract

@Composable
fun getStageList(
    state: StageContract.State,
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val height = minHeight / state.stageList.size
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            state.stageList.forEachIndexed { index, stage ->
                StageCardItem(
                    modifier = Modifier.height(height),
                    stage = stage,
                    onClick = {

                    }
                )
            }
        }
    }
}