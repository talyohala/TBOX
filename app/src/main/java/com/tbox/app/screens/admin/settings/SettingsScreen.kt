package com.tbox.app.screens.admin.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tbox.app.viewmodels.SettingsViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel = viewModel()) {
    val settings = viewModel.settings.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("הגדרות מערכת", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        SettingSwitch(
            label = "אפשר תגובות",
            checked = settings.value.enableComments,
            onCheckedChange = { viewModel.updateSetting("enableComments", it) }
        )

        SettingSwitch(
            label = "אפשר צפייה בלייב",
            checked = settings.value.enableLive,
            onCheckedChange = { viewModel.updateSetting("enableLive", it) }
        )

        SettingSwitch(
            label = "הרשמה פתוחה",
            checked = settings.value.allowSignup,
            onCheckedChange = { viewModel.updateSetting("allowSignup", it) }
        )
    }
}

@Composable
fun SettingSwitch(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label)
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}
