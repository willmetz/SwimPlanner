package com.slapshotapps.swimplanner.home.viewmodels

import com.slapshotapps.swimplanner.api.models.SwimStroke
import com.slapshotapps.swimplanner.api.models.Workout
import com.slapshotapps.swimplanner.api.models.WorkoutSet
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.util.ArrayList

class CompletedWorkoutViewModelTest {
    lateinit var workout : Workout
    val workoutSets = ArrayList<WorkoutSet>()

    @Before
    fun setUp() {
        val strokes1 = ArrayList<SwimStroke>()
        strokes1.add(SwimStroke.BACK)
        strokes1.add(SwimStroke.FLY)

        val strokes2 = ArrayList<SwimStroke>()
        strokes2.add(SwimStroke.BACK)

        val strokes3 = ArrayList<SwimStroke>()
        strokes3.add(SwimStroke.FREE)

        val workoutSet1 = WorkoutSet(1, strokes1, 75, 10, "alternate strokes")
        val workoutSet2 = WorkoutSet(2, strokes2, 125, 5, "N/A")
        val workoutSet3 = WorkoutSet(3, strokes3, 1000, 1, "sprint")

        workoutSets.add(workoutSet1)
        workoutSets.add(workoutSet2)
        workoutSets.add(workoutSet3)

        workout = Workout(2, "bob", "01-04-2018", "01-05-2018", workoutSets)
    }

    @Test
    fun testTotalWorkoutYards(){
        val viewModel = CompletedWorkoutViewModel(workout)

        assertEquals("Total Workout Yards: 2375", viewModel.totalWorkoutYards())
    }
}