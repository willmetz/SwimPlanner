package com.slapshotapps.swimplanner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.slapshotapps.swimplanner.api.models.SwimStroke
import com.slapshotapps.swimplanner.api.models.Workout
import com.slapshotapps.swimplanner.api.models.WorkoutSet
import com.slapshotapps.swimplanner.home.viewmodels.CompletedWorkoutViewModel
import com.slapshotapps.swimplanner.home.viewmodels.UpcomingWorkoutViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



    }

    override fun onResume() {
        super.onResume()

        navigation_bar.selectedItemId = R.id.action_home;

        createTestData()
    }

    private fun createTestData(){
        val freeStyleList = ArrayList<SwimStroke>();
        freeStyleList.add(SwimStroke.FREE)
        val workoutSet1 = WorkoutSet(1, freeStyleList,150, 6, "2 minute interval");
        val workoutSet2 = WorkoutSet(2, freeStyleList,50, 10, "dead sprint");

        val otherStrokeList = ArrayList<SwimStroke>();
        otherStrokeList.add(SwimStroke.FLY)
        otherStrokeList.add(SwimStroke.BACK)
        otherStrokeList.add(SwimStroke.BREAST)
        otherStrokeList.add(SwimStroke.FREE)

        val workoutSet3 = WorkoutSet(3, otherStrokeList,200, 4, "4 minute interval");
        val workoutSet4 = WorkoutSet(4, otherStrokeList,100, 4, "2 minute interval");

        val upcomingWorkoutSets = ArrayList<WorkoutSet>()
        upcomingWorkoutSets.add(workoutSet1)
        upcomingWorkoutSets.add(workoutSet2)
        upcomingWorkoutSets.add(workoutSet3)
        upcomingWorkoutSets.add(workoutSet4)

        val upcomingWorkout = Workout(1, "test", "03-20-2018", "", upcomingWorkoutSets)

        val upcomingWorkoutVM = UpcomingWorkoutViewModel(upcomingWorkout)

        upcoming_workout.setWorkout(upcomingWorkoutVM)
    }
}
