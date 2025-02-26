package com.dcengineer.threedemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.multiplatform.webview.jsbridge.IJsMessageHandler
import com.multiplatform.webview.jsbridge.JsMessage
import com.multiplatform.webview.jsbridge.rememberWebViewJsBridge
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.WebViewNavigator
import com.multiplatform.webview.web.rememberWebViewNavigator
import com.multiplatform.webview.web.rememberWebViewStateWithHTMLData
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import threedemo.composeapp.generated.resources.Res

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    var html by remember { mutableStateOf("") }
    var js by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        html = Res.readBytes("files/index.html").decodeToString()
        js = Res.readBytes("files/cube.js").decodeToString()
    }

    MaterialTheme {
        ThreeJsWebView(html.replace("/*CODE*/", js))
    }
}

@Composable
fun ThreeJsWebView(html: String) {
    val webViewState = rememberWebViewStateWithHTMLData(
        data = html
    )
    val navigator = rememberWebViewNavigator()
    var scale by remember { mutableStateOf(1f) }
    val bridge = rememberWebViewJsBridge()
    var quaternion by remember { mutableStateOf("") }
    bridge.register(QuaternionMessageHandler(handler = { quaternion = it }))
    Column {
        Text("Three.js in Compose Multiplatform!",
            modifier = Modifier.padding(12.dp),
            style = MaterialTheme.typography.h5
        )
        WebView(
            state = webViewState,
            modifier = Modifier.weight(1f),
            navigator = navigator,
            webViewJsBridge = bridge
        )
        Slider(
            value = scale,
            onValueChange = {
                scale = it
                navigator.evaluateJavaScript("cube.scale.set($scale, $scale, $scale);")
            },
            modifier = Modifier.padding(12.dp),
            valueRange = 0.1f..2f
        )
        Text(quaternion, modifier = Modifier.padding(12.dp))
    }
}

class QuaternionMessageHandler(val handler: (String) -> Unit): IJsMessageHandler {
    override fun handle(
        message: JsMessage,
        navigator: WebViewNavigator?,
        callback: (String) -> Unit
    ) {
        handler(message.params)
    }

    override fun methodName(): String {
        return "Quaternion"
    }
}
