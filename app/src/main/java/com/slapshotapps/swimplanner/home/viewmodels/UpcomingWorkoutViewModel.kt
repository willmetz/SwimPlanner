package com.slapshotapps.swimplanner.home.viewmodels

import com.slapshotapps.swimplanner.api.models.Workout
import com.slapshotapps.swimplanner.api.models.WorkoutSet
import java.text.SimpleDateFormat
import java.util.*


class UpcomingWorkoutViewModel(val workout: Workout) {

    val serviceDateFormat = SimpleDateFormat("MM-dd-yyyy", Locale.US)
    val targetDisplayDateFormat = SimpleDateFormat("E MMMM d", Locale.US)

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

    fun setOne(): String {
        if (workout.sets.size > 0) {
            return setToString(workout.sets[0])
        } else {
            return ""
        }
    }

    fun setTwo(): String {
        if (workout.sets.size > 1) {
            return setToString(workout.sets[1])
        } else {
            return ""
        }
    }

    fun setThree(): String {
        if (workout.sets.size > 2) {
            return setToString(workout.sets[2])
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
        var setString = set.repetitions.toString() + " x " + set.yards.toString() + " ";

        for (i in set.strokes.indices) {
            setString += set.strokes[i].str

            if (i + 1 < set.strokes.size) {
                setString += ", "
            }
        }

        return setString
    }
}