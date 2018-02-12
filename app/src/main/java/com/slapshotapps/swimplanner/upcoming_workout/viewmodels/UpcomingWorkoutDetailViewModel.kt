package com.slapshotapps.swimplanner.upcoming_workout.viewmodels

import com.slapshotapps.swimplanner.api.models.Workout
import com.slapshotapps.swimplanner.utils.weekdayShortMonthDayFormat
import java.util.*


class UpcomingWorkoutDetailViewModel(val workout: Workout) {

    fun workoutDate(): String {
        return weekdayShortMonthDayFormat.format(workout.targetDate())
    }

    fun totalWorkoutYards(): String {
        var totalYards = 0

        for (workoutSet in workout.sets) {
            totalYards += workoutSet.yards * workoutSet.repetitions
        }

        return totalYards.toString()
    }
}