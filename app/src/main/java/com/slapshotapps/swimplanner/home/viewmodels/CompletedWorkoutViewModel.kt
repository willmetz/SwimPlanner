package com.slapshotapps.swimplanner.home.viewmodels

import com.slapshotapps.swimplanner.api.models.Workout
import com.slapshotapps.swimplanner.utils.dayPostfix
import java.text.SimpleDateFormat
import java.util.*


class CompletedWorkoutViewModel(val workout: Workout) {

    val completedDisplayDateFormat = SimpleDateFormat("MMM d", Locale.US)

    fun totalWorkoutYards(): String {
        var totalYards = 0

        for (workoutSet in workout.sets) {
            totalYards += workoutSet.yards * workoutSet.repetitions
        }

        return "Total Workout Yards: " + totalYards.toString()
    }

    fun completedDate(): String {

        val targetDate = workout.completedDate()
        val cal = Calendar.getInstance()
        cal.time = targetDate

        return "Completed " + completedDisplayDateFormat.format(targetDate) + dayPostfix(
            cal.get(Calendar.DAY_OF_MONTH))
    }
}