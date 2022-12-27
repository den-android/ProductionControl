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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.productioncontrol.domain.model.Stage
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
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column(
            modifier
                .fillMaxSize(),
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
//        Text(
//            text = "${stage.name}",
//            overflow = TextOverflow.Ellipsis,
//            maxLines = 1,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .border(width = 1.dp, color = Color.Black)
//                .background(color = lightPurple)
//                .fillMaxWidth(),
//        )

