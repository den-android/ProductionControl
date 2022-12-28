package net.denis.productioncontrol.presentation.screen.components

import android.widget.RadioGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.productioncontrol.domain.model.Checklist
import net.denis.productioncontrol.presentation.screen.ChecklistScreen

@Composable
fun ChecklistCardItem(
    checklist: Checklist,
    modifier: Modifier = Modifier,
    loadNextChecklistItem:() -> Unit,
) {

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .padding(4.dp)
            .fillMaxSize(),
        elevation = 4.dp,

    ) {
        Column(
            modifier
                .fillMaxSize(),
        ) {
            Box(modifier = modifier.weight(2f)) {
                Text(
                    text = checklist.name,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    modifier = modifier
                        .padding(6.dp),
                )
            }
            Box(
                modifier = modifier
                    .weight(1f)
                    .padding(6.dp)
            ) {
                Button(
                    onClick = {
                        loadNextChecklistItem
                    },
                    modifier = modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Перейти к следующему",
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Clip,
                        fontSize = 32.sp,
                    )
                }
            }
            Box(modifier = modifier.weight(4f)) {
                RadioGroup(onRadioClick = {
                    if (it != Color.Green) {
                        loadNextChecklistItem()
                    }
                })
            }

        }
    }

}
@Preview(showBackground = true)
@Composable
fun ShowTest(){
    ChecklistCardItem(
        checklist = Checklist(0,"Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text Some text "),
        modifier = Modifier,
    loadNextChecklistItem = {})
}