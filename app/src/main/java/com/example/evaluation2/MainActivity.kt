package com.example.evaluation2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var dbHandler: DataBaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler= DataBaseHandler(this)
        insertBtn.setOnClickListener{
            dbHandler.insertRoutine("birthday","this is orginizing for children","10/1/2001","New Delhi",200)
        }

        dbHandler = DataBaseHandler(this)
        updateBtn.setOnClickListener{
            dbHandler.updateRoutine(7,"Saveen","new party","30/02/2005","America",500)
        }
        dbHandler= DataBaseHandler(this)

        deleteBtn.setOnClickListener{
            dbHandler.deleteRoutine(1)
        }
    }
}