package com.tbox.app.viewmodels

class StatisticsManager {

    fun calculateTotalViews(stats: Map<String, Int>): Int {
        var total = 0
        stats.forEach { (_, value) ->
            total += value
        }
        return total
    }

    fun calculateAverage(stats: Map<String, Int>): Double {
        if (stats.isEmpty()) return 0.0
        val sum = stats.values.sum()
        return sum.toDouble() / stats.size
    }

    fun getMostViewedTag(stats: Map<String, Int>): String? {
        return stats.maxByOrNull { it.value }?.key
    }
}
