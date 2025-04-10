package com.tbox.app.model

sealed class AdminCommand(val title: String) {
    object AddMovie : AdminCommand("הוסף סרט")
    object EditMovie : AdminCommand("ערוך סרט")
    object DeleteMovie : AdminCommand("מחק סרט")
    object ViewStats : AdminCommand("צפייה בסטטיסטיקה")
    object ManageUsers : AdminCommand("ניהול משתמשים")
    object BackupData : AdminCommand("גיבוי נתונים")
    object SendBroadcast : AdminCommand("שליחת הודעה")
    object ViewLogs : AdminCommand("צפייה בלוגים")
    object ManageTasks : AdminCommand("ניהול משימות")
    object DailyReports : AdminCommand("דו\"חות יומיים")
    object Settings : AdminCommand("הגדרות")
}
