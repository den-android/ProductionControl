package net.denis.productioncontrol.presentation.screen.stage_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChecklistCardItem(
    modifier: Modifier = Modifier,
    text: String
) {
    val checklistNameScroll = rememberScrollState(0)
    Card(
        modifier = modifier
            .padding(4.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 4.dp,
    ) {
        Column {
            Box(modifier = modifier.weight(1f)) {
                Text(
                    modifier = modifier
                        .padding(bottom = 8.dp)
                        .verticalScroll(checklistNameScroll),
                    fontSize = 24.sp,
                    overflow = TextOverflow.Clip,
                    textAlign = TextAlign.Start,
                    style = TextStyle(textIndent = TextIndent(20.sp)),
                    text = text,
                )
            }
            Box(modifier = modifier.weight(2f)) {
                CustomRadioGroup(onRadioClick = {
                    when (it) {
                        Color.Green -> 0
                        Color.Yellow -> 1
                        Color.Red -> 2
                    }
                })
            }

        }
    }

}

/*
@Composable
fun ChecklistCardItem(
    text: String,
    modifier: Modifier = Modifier,
    onRadioClick: (Int) -> Unit,
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .padding(4.dp)
            .fillMaxSize(),
        elevation = 4.dp,
    ) {
        Column {
            Box(modifier = modifier.weight(2f)) {
                Text(
                    text = text,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    modifier = modifier
                        .padding(6.dp),
                )
            }
            Box(modifier = modifier.weight(4f)) {
                RadioGroup(onRadioClick = {
                    when (it) {
                        Color.Green -> 0
                        Color.Yellow -> 1
                        Color.Red -> 2
                    }
                })
            }

        }
    }

}
 */