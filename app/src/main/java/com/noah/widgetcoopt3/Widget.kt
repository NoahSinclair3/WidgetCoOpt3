package com.noah.widgetcoopt3

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.CheckBox
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

class MyAppWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = AppWidget()
}

class AppWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        // Load data needed to render the AppWidget.
        // Use `withContext` to switch to another thread for long running
        // operations.

        provideContent {
            // create your AppWidget here
            Content()
        }
    }

    @Composable
    private fun Content() {
        var check : Boolean by remember {mutableStateOf(false)}
        var check2 : Boolean by remember {mutableStateOf(false)}

        Column(
            modifier = GlanceModifier.fillMaxSize(),
            verticalAlignment = Alignment.Top,
        ) {
            Text(text = "Things to do",
                modifier = GlanceModifier.padding(12.dp),
                style = TextStyle(color = ColorProvider(Color.White))
            )
            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                CheckBox(checked = check,
                    onCheckedChange = {check = !check},
                    text = "Finish CoOpt",
                    style = TextStyle(color = ColorProvider(Color.White))
                )
            }
            Row(horizontalAlignment = Alignment.CenterHorizontally) {
                CheckBox(checked = check2,
                    onCheckedChange = {check2 = !check2},
                    text = "Play games",
                    style = TextStyle(color = ColorProvider(Color.White))
                )
            }
        }
    }
}