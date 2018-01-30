package com.slapshotapps.swimplanner.upcoming_workout.viewmodels


import com.slapshotapps.swimplanner.api.models.SwimStroke
import com.slapshotapps.swimplanner.api.models.WorkoutSet
import junit.framework.Assert.assertEquals
import org.junit.Test

class WorkoutRowViewModelTest{

    @Test
    fun testWorkoutSetYardsAndReps(){

        val strokesList = ArrayList<SwimStroke>()
        strokesList.add(SwimStroke.FREE)
        strokesList.add(SwimStroke.FLY)

        val workoutSet = WorkoutSet(0, strokesList, 200, 8, "N/A")

        val viewModel = WorkoutRowViewModel(workoutSet)

        assertEquals("8 x 200", viewModel.yardsAndReps())
    }

    @Test
    fun testWorkoutSetStrokes(){
        val strokesList = ArrayList<SwimStroke>()
        strokesList.add(SwimStroke.FREE)
        strokesList.add(SwimStroke.FLY)
        strokesList.add(SwimStroke.BACK)

        val workoutSet = WorkoutSet(0, strokesList, 100, 8, "N/A")

        val viewModel = WorkoutRowViewModel(workoutSet)

        assertEquals("Free, Fly, Back", viewModel.setStrokes())
    }

    @Test
    fun testWorkoutSetOneStroke(){
        val strokesList = ArrayList<SwimStroke>()
        strokesList.add(SwimStroke.IM)

        val workoutSet = WorkoutSet(0, strokesList, 100, 8, "N/A")

        val viewModel = WorkoutRowViewModel(workoutSet)

        assertEquals("IM", viewModel.setStrokes())
    }

    @Test
    fun testWorkoutSetYardage(){
        val strokesList = ArrayList<SwimStroke>()
        strokesList.add(SwimStroke.IM)

        val workoutSet = WorkoutSet(0, strokesList, 100, 8, "N/A")

        val viewModel = WorkoutRowViewModel(workoutSet)

        assertEquals("800 yards", viewModel.workoutYardage())
    }
}