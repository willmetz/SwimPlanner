package com.slapshotapps.swimplanner.home.viewmodels

import com.slapshotapps.swimplanner.api.models.Workout
import com.slapshotapps.swimplanner.api.models.WorkoutSet
import java.text.SimpleDateFormat
import java.util.*


class UpcomingWorkoutViewModel(val workout: Workout) {

    val serviceDateFormat = SimpleDateFormat("MM-dd-yyyy", Locale.US)
    val targetDisplayDateFormat = SimpleDateFormat("EEEEE MMMM d", Locale.US)

    fun targetDate(): String {
        val targetDate = serviceDateFormat.parse(workout.targetDate)
        val cal = Calendar.getInstance()
        cal.time = targetDate

        return targetDisplayDateFormat.format(targetDate) + dayPostfix(
            cal.get(Calendar.DAY_OF_MONTH))
    }

    private fun dayPostfix(day: Int): String {

        when (day) {
            1, 21, 31 -> return "st"
            2, 22 -> return "nd"
            3, 23 -> return "rd"
            else -> return "th"
        }
    }

    fun setWorkout(setOneBased: Int): String {
        if (workout.sets.size >= setOneBased) {
            return setToString(workout.sets[setOneBased - 1])
        } else {
            return ""
        }
    }

    fun setStrokes(setOneBased: Int): String {
        if (!setWorkout(setOneBased).isEmpty()) {
            return strokesForSet(workout.sets[setOneBased - 1])
        } else {
            return ""
        }
    }

    fun totalWorkoutYards(): String {
        var totalYards = 0

        for (workoutSet in workout.sets) {
            totalYards += workoutSet.yards * workoutSet.repetitions
        }

        return totalYards.toString() + " yards"
    }

    private fun setToString(set: WorkoutSet): String {
        return set.repetitions.toString() + " x " + set.yards.toString();
    }

    private fun strokesForSet(set: WorkoutSet): String {

        var setStrokes = ""

        for (i in set.strokes.indices) {
            setStrokes += set.strokes[i].str

            if (i + 1 < set.strokes.size) {
                setStrokes += ", "
            }
        }

        return setStrokes
    }
}