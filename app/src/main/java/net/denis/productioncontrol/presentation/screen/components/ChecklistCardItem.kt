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
import androidx.compose.ui.tooling.preview.Preview
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
            .padding(4.dp)
            .fillMaxSize(),
        elevation = 4.dp,

    ) {
        Column(
            modifier
                .fillMaxSize(),
        ) {
            Box(modifier = modifier.weight(1f)) {
                Text(
                    text = checklist.name,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    modifier = modifier
                        .padding(6.dp),
                )
            }
            Box(modifier = modifier.weight(2f)) {
                RadioGroup()
            }
        }
    }

}