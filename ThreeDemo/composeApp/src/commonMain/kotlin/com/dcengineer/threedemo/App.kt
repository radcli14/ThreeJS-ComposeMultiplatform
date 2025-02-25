package com.dcengineer.threedemo

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewStateWithHTMLData
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val html = """
    <html>
        <body>
            <h1>Three.js will go here!</h1>
            <p>Soon with JavaScript...</p>
        </body>
    </html>
    """.trimIndent()
    val webViewState = rememberWebViewStateWithHTMLData(
        data = html
    )

    MaterialTheme {
        WebView(webViewState)
    }
}