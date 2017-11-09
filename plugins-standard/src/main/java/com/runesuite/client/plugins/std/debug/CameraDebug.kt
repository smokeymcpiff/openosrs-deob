package com.runesuite.client.plugins.std.debug

import com.runesuite.client.game.api.Scene
import com.runesuite.client.game.api.live.LiveCamera
import com.runesuite.client.game.api.live.LiveCanvas
import com.runesuite.client.game.api.live.LiveScene
import com.runesuite.client.game.api.live.Players
import com.runesuite.client.plugins.DisposablePlugin
import com.runesuite.client.plugins.PluginSettings
import com.runesuite.client.plugins.util.ColorForm
import com.runesuite.client.plugins.util.FontForm
import java.awt.Font

class CameraDebug : DisposablePlugin<CameraDebug.Settings>() {

    override val defaultSettings = Settings()

    override fun start() {
        super.start()
        add(LiveCanvas.repaints.subscribe { g ->
            g.font = settings.font.get()
            g.color = settings.color.get()
            g.drawString(LiveCamera.toString(), 5, 40)
        })
    }

    class Settings : PluginSettings() {
        val font = FontForm(Font.SANS_SERIF, FontForm.BOLD, 15f)
        val color = ColorForm()
    }
}