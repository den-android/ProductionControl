package net.denis.productioncontrol.presentation.screen.stage_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.productioncontrol.presentation.model.Stage

@Composable
fun StageCardItem(
    modifier: Modifier = Modifier,
    stage: Stage,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.small,
        elevation = 8.dp
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stage.name,
                fontSize = 30.sp,
                style = MaterialTheme.typography.h3
            )
        }
    }
}