package net.denis.productioncontrol.presentation.screen.components

import android.widget.RadioGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.productioncontrol.domain.model.Checklist

@Composable
fun ChecklistCardItem(
    checklist: Checklist,
    modifier: Modifier = Modifier,
) {

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(
            modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = checklist.name,
                fontSize = 12.sp,
            )
            RadioGroup()
        }
    }
}