package com.tbox.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tbox.app.models.Settings
import com.tbox.app.repository.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel() {
    private val repository = SettingsRepository()

    private val _settings = MutableStateFlow(Settings())
    val settings: StateFlow<Settings> = _settings

    init {
        loadSettings()
    }

    private fun loadSettings() {
        viewModelScope.launch {
            _settings.value = repository.loadSettings()
        }
    }

    fun updateSetting(key: String, value: Boolean) {
        viewModelScope.launch {
            repository.updateSetting(key, value)
            _settings.value = repository.loadSettings()
        }
    }
}
