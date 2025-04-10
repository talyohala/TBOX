package com.tbox.app.viewmodels

import com.tbox.app.models.Report
import java.text.SimpleDateFormat
import java.util.*

class ReportManager {

    fun generateDailyReport(): Report {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        // ערכים מדומים – בהמשך נחבר למסד נתונים
        val activeUsers = (20..100).random()
        val newComments = (0..20).random()
        val newMovies = (0..5).random()

        return Report(
            date = today,
            activeUsers = activeUsers,
            newComments = newComments,
            newMovies = newMovies
        )
    }
}
