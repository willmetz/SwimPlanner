package com.slapshotapps.swimplanner.home.viewmodels

import com.slapshotapps.swimplanner.api.models.Workout


class CompletedWorkoutViewModel(val workout: Workout) {

    fun totalWorkoutYards(): String {
        var totalYards = 0

        for (workoutSet in workout.sets) {
            totalYards += workoutSet.yards * workoutSet.repetitions
        }

        return "Total Workout Yards: " + totalYards.toString()
    }
}