package com.tbox.app.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tbox.app.models.Settings
import java.io.File

class SettingsRepository {
    private val fileName = "settings.json"
    private val gson = Gson()

    private fun getFile(): File {
        val dir = File("data")
        if (!dir.exists()) dir.mkdirs()
        return File(dir, fileName)
    }

    fun loadSettings(): Settings {
        val file = getFile()
        return if (file.exists()) {
            val json = file.readText()
            gson.fromJson(json, object : TypeToken<Settings>() {}.type)
        } else {
            val default = Settings()
            saveSettings(default)
            default
        }
    }

    fun updateSetting(key: String, value: Boolean) {
        val current = loadSettings()
        val updated = current.copy(
            enableComments = if (key == "enableComments") value else current.enableComments,
            enableLive = if (key == "enableLive") value else current.enableLive,
            allowSignup = if (key == "allowSignup") value else current.allowSignup,
        )
        saveSettings(updated)
    }

    private fun saveSettings(settings: Settings) {
        val file = getFile()
        file.writeText(gson.toJson(settings))
    }
}
