package com.slapshotapps.swimplanner.upcoming_workout.viewmodels

import com.slapshotapps.swimplanner.api.models.WorkoutSet
import java.util.*


class WorkoutRowViewModel(val workoutSet: WorkoutSet) {

    fun yardsAndReps(): String {
        return String.format(Locale.US, "%d x %d", workoutSet.repetitions, workoutSet.yards)
    }

    fun setStrokes(): String {
        var strokes = ""

        for (i in 0 until workoutSet.strokes.size) {
            strokes += workoutSet.strokes.get(i).str

            if (i < workoutSet.strokes.size - 1) {
                strokes += ", "
            }
        }

        return strokes
    }

    fun workoutYardage(): String {
        return String.format(Locale.US, "%d yards", workoutSet.repetitions * workoutSet.yards);
    }

    fun workoutNotes(): String {
        return workoutSet.notes
    }

}