package com.slapshotapps.swimplanner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


    }

    override fun onResume() {
        super.onResume()

        navigation_bar.selectedItemId = R.id.action_home;
    }
}
