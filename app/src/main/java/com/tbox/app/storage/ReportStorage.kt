package com.tbox.app.storage

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tbox.app.models.Report
import java.io.File

class ReportStorage(private val context: Context) {

    private val gson = Gson()
    private val reportsDir = File(context.filesDir, "reports")

    init {
        if (!reportsDir.exists()) {
            reportsDir.mkdirs()
        }
    }

    fun saveReport(report: Report) {
        val file = File(reportsDir, "${report.date}.json")
        file.writeText(gson.toJson(report))
    }

    fun loadReport(date: String): Report? {
        val file = File(reportsDir, "$date.json")
        return if (file.exists()) {
            val json = file.readText()
            gson.fromJson(json, object : TypeToken<Report>() {}.type)
        } else null
    }

    fun listAvailableReports(): List<String> {
        return reportsDir.listFiles()?.mapNotNull {
            it.nameWithoutExtension
        }?.sortedDescending() ?: emptyList()
    }
}
