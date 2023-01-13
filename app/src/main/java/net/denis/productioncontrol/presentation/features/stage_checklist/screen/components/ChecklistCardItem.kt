package net.denis.productioncontrol.presentation.features.stage_checklist.screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.productioncontrol.presentation.model.Checklist

@Composable
fun ChecklistCardItem(
    modifier: Modifier = Modifier,
    checklist: Checklist,
    statusClick: (Int) -> Unit,
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
                    text = checklist.name,
                )
            }

            Box(modifier = modifier.weight(2f)) {
                CustomRadioGroup(
                    onRadioClicked = {
                        when (it) {
                            Color.Green -> {
                                statusClick(0)
                            }
                            Color.Yellow -> {
                                statusClick(1)
                            }
                            Color.Red -> {
                                statusClick(2)
                            }
                        }

                    })
            }
        }

    }

}