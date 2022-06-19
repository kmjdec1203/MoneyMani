package com.example.moneymani.viewmodels

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.moneymani.R
import com.example.moneymani.ui.TodoActivity

class MainModel(private var activity : AppCompatActivity, private var context: Context) : ViewModel {


    override fun onCreate() {

    }

    fun clickEvent(view : View) {

        when(view.id) {

            R.id.addNewTodoFab -> {
                activity.startActivity(Intent(context, TodoActivity::class.java))
                activity.finish()
            }

        }

    }

}