package com.slapshotapps.swimplanner.upcoming_workout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.slapshotapps.swimplanner.R


class UpcomingWorkoutDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_upcoming_workout_detail)
    }

    companion object {
        fun getIntent(context: Context) : Intent{
            return Intent(context, UpcomingWorkoutDetailActivity::class.java)
        }
    }
}