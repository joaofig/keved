package io.joaofig.keved

import io.kvision.Application
import io.kvision.CoreModule
import io.kvision.BootstrapModule
import io.kvision.BootstrapCssModule
import io.kvision.DatetimeModule
import io.kvision.TomSelectModule
import io.kvision.BootstrapUploadModule
import io.kvision.ToastifyModule
import io.kvision.FontAwesomeModule
import io.kvision.BootstrapIconsModule
import io.kvision.ChartModule
import io.kvision.TabulatorModule
import io.kvision.TabulatorCssBootstrapModule
import io.kvision.MapsModule
import io.kvision.Hot
import io.kvision.html.Span
import io.kvision.i18n.DefaultI18nManager
import io.kvision.i18n.I18n
import io.kvision.panel.root
import io.kvision.remote.registerRemoteTypes
import io.kvision.startApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

val AppScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

@JsModule("/kotlin/modules/i18n/messages-en.json")
external val messagesEn: dynamic

@JsModule("/kotlin/modules/i18n/messages-pl.json")
external val messagesPl: dynamic

class App : Application() {

    override fun start(state: Map<String, Any>) {
        I18n.manager =
            DefaultI18nManager(
                mapOf(
                    "en" to messagesEn,
                    "pl" to messagesPl
                )
            )

        val root = root("kvapp") {
        }
        AppScope.launch {
            val pingResult = Model.ping("Hello world from client!")
            root.add(Span(pingResult))
        }
    }
}

fun main() {
    registerRemoteTypes()
    startApplication(
        ::App,
        js("import.meta.webpackHot").unsafeCast<Hot?>(),
        BootstrapModule,
        BootstrapCssModule,
        DatetimeModule,
        TomSelectModule,
        BootstrapUploadModule,
        ToastifyModule,
        FontAwesomeModule,
        BootstrapIconsModule,
        ChartModule,
        TabulatorModule,
        TabulatorCssBootstrapModule,
        MapsModule,
        CoreModule
    )
}
