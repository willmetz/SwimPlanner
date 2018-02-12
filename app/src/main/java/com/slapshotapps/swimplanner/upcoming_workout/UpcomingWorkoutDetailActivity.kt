package com.slapshotapps.swimplanner.upcoming_workout

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.slapshotapps.swimplanner.R
import com.slapshotapps.swimplanner.api.models.Workout
import com.slapshotapps.swimplanner.databinding.ActivityUpcomingWorkoutDetailBinding
import com.slapshotapps.swimplanner.upcoming_workout.viewmodels.UpcomingWorkoutDetailViewModel
import com.slapshotapps.swimplanner.upcoming_workout.viewmodels.WorkoutRowViewModel


class UpcomingWorkoutDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityUpcomingWorkoutDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val workout = intent.getParcelableExtra<Workout>(WORKOUT_KEY)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_upcoming_workout_detail)
        binding.item = UpcomingWorkoutDetailViewModel(workout)

        initWorkout(workout)
    }

    private fun initWorkout(workout: Workout) {
        val workoutVMs = ArrayList<WorkoutRowViewModel>(workout.sets.size)
        for (workoutSet in workout.sets) {
            workoutVMs.add(WorkoutRowViewModel(workoutSet))
        }
        binding.workoutList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
        binding.workoutList.adapter = UpcomingWorkoutAdapter(workoutVMs)
    }

    companion object {

        val WORKOUT_KEY = "WorkoutKey"

        fun getIntent(context: Context, workout: Workout): Intent {

            val intent = Intent(context, UpcomingWorkoutDetailActivity::class.java)

            intent.putExtra(WORKOUT_KEY, workout)

            return intent
        }
    }
}