package net.denis.productioncontrol.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.productioncontrol.domain.model.Checklist
import net.denis.productioncontrol.domain.model.Stage
import net.denis.productioncontrol.presentation.navigation.Screen
import net.denis.productioncontrol.presentation.ui.theme.lightPurple
import org.intellij.lang.annotations.JdkConstants

@Composable
fun StageCardItem(
    stage: Stage,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )

            .clickable(onClick = onClick),
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