package com.tbox.app.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.tbox.app.screens.admin.content.AdminContentScreen
import com.tbox.app.screens.admin.settings.AdminSettingsScreen
import com.tbox.app.screens.admin.files.FileManagerScreen
import com.tbox.app.screens.admin.statistics.StatisticsScreen
import com.tbox.app.screens.admin.comments.AdminCommentsScreen
import com.tbox.app.screens.admin.reports.ReportsScreen
import com.tbox.app.screens.admin.alerts.AdminAlertsScreen

fun NavGraphBuilder.adminGraph(
    navController: NavHostController
) {
    navigation(startDestination = "admin/content", route = "admin") {

        composable("admin/content") {
            AdminContentScreen(navController)
        }

        composable("admin/settings") {
            AdminSettingsScreen(navController)
        }

        composable("admin/files") {
            FileManagerScreen(navController)
        }

        composable("admin/statistics") {
            StatisticsScreen(navController)
        }

        composable("admin/comments") {
            AdminCommentsScreen(navController)
        }

        composable("admin/reports") {
            ReportsScreen(navController)
        }

        composable("admin/alerts") {
            val dummyAlerts = listOf(
                AlertItem("שגיאה במסד הנתונים", AlertType.WARNING),
                AlertItem("עדכון מערכת זמין", AlertType.INFO)
            )
            AdminAlertsScreen(alerts = dummyAlerts) {
                // פעולה לאחר טיפול
            }
        }
    }
}
