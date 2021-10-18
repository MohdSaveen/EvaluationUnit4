package com.example.evaluation2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DataBaseHandler(val context: Context):
    SQLiteOpenHelper(context,"Event",null,1){

    companion object{
        val TABLE_NAME="Event_registration"
        val ID="id"
        val EVENT_NAME="event_name"
        val EVENT_DESC= "event_desc"
        val EVENT_DATE ="event_date"
        val EVENT_LOCATION ="event_location"
        val EVENT_PRICE ="event_price"

    }
    override fun onCreate(db: SQLiteDatabase?) {

        val createQuery="CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY,$EVENT_NAME TEXT, $EVENT_DESC TEXT, $EVENT_DATE TEXT, $EVENT_LOCATION TEXT, $EVENT_PRICE INTEGER)"

        db?.execSQL(createQuery)

    }

    fun insertRoutine(eventName:String,eventDesc : String,eventDate :String,eventLocation : String,eventPrice:Int){

        val db=writableDatabase
        val values=ContentValues()
        values.put(EVENT_NAME,eventName)
        values.put(EVENT_DESC,eventDesc)
        values.put(EVENT_DATE,eventDate)
        values.put(EVENT_LOCATION,eventLocation)
        values.put(EVENT_PRICE,eventPrice)

        val id=db.insert(TABLE_NAME,null,values)

        if (id.toInt()==-1){
            Toast.makeText(context,"Data not inserted",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(context,"Data inserted successfully",Toast.LENGTH_SHORT).show()

        }



    }

    fun updateRoutine(id: Int,eventName:String,eventDesc : String,eventDate :String,eventLocation : String,eventPrice:Int){

        val db=writableDatabase
        val values=ContentValues()
        // values.put(ID,id)
        values.put(EVENT_NAME,eventName)
        values.put(EVENT_DESC,eventDesc)
        values.put(EVENT_DATE,eventDate)
        values.put(EVENT_LOCATION,eventLocation)
        values.put(EVENT_PRICE,eventPrice)

        val affectedRows =db.update(TABLE_NAME, values,"id = $id",null)

        if (affectedRows>0){
            Toast.makeText(context,"update Successfully",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(context,"Error updating",Toast.LENGTH_SHORT).show()

        }


    }
    fun deleteRoutine(id :Int){
        val db=writableDatabase

        val affectedRows =db.delete(TABLE_NAME,"id = $id",null)

        if (affectedRows > 0){
            Toast.makeText(context,"Delete SuccessFully",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(context,"Not Deleted",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}