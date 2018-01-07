package com.slapshotapps.swimplanner.home.viewmodels

import com.slapshotapps.swimplanner.api.models.SwimStroke
import com.slapshotapps.swimplanner.api.models.Workout
import com.slapshotapps.swimplanner.api.models.WorkoutSet
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class UpcomingWorkoutViewModelTest {

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

        val workoutSet1 = WorkoutSet(1, strokes1, 50, 10, "alternate strokes")
        val workoutSet2 = WorkoutSet(2, strokes2, 500, 5, "N/A")
        val workoutSet3 = WorkoutSet(3, strokes3, 100, 1, "sprint")

        workoutSets.add(workoutSet1)
        workoutSets.add(workoutSet2)
        workoutSets.add(workoutSet3)

        workout = Workout(2, "bob", "01-04-2018", "01-05-2018", workoutSets)
    }

    @Test
    fun testTargetDate(){

        val serviceDateFormat = SimpleDateFormat("MM-dd-yyyy", Locale.US)
        var viewModel = UpcomingWorkoutViewModel(workout)

        val targetDate = Calendar.getInstance()
        targetDate.set(2018, Calendar.JANUARY, 1)

        var i = 1
        while(i < 32){
            targetDate.set(2018, Calendar.JANUARY, i)

            viewModel = UpcomingWorkoutViewModel(Workout(1,"bob",
                serviceDateFormat.format(targetDate.time),
                "11-12-2018", workoutSets))

            val dayName = targetDate.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, Locale.US)

            var suffix = "th"
            when(i){
                1,21,31 -> suffix = "st"
                2,22 -> suffix = "nd"
                3,23 -> suffix = "rd"
                else -> suffix = "th"
            }

            assertEquals(dayName + " January " + i + suffix, viewModel.targetDate())

            i++
        }
    }

    @Test
    fun testSetOne(){
        val viewModel = UpcomingWorkoutViewModel(workout)

        assertEquals("10 x 50 Back, Fly", viewModel.setOne())
    }

    @Test
    fun testSetTwo(){
        val viewModel = UpcomingWorkoutViewModel(workout)

        assertEquals("5 x 500 Back", viewModel.setTwo())
    }

    @Test
    fun testSetThree(){
        val viewModel = UpcomingWorkoutViewModel(workout)

        assertEquals("1 x 100 Free", viewModel.setThree())
    }

    @Test
    fun testTotalWorkoutYards(){
        val viewModel = UpcomingWorkoutViewModel(workout)

        assertEquals("3100 yards", viewModel.totalWorkoutYards())
    }
}