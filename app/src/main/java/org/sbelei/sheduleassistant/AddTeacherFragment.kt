package org.sbelei.sheduleassistant

import android.content.ContentValues
import android.support.v4.app.Fragment
import android.os.Bundle
import android.provider.BaseColumns
import android.support.design.widget.TextInputEditText
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_add_teacher.*
import kotlinx.android.synthetic.main.fragment_add_teacher.view.*
import org.sbelei.sheduleassistant.persistance.ScheduleAssistantDbHelper
import org.sbelei.sheduleassistant.persistance.TeacherContract

/**
 * A placeholder fragment containing a simple view.
 */
class AddTeacherFragment : Fragment() {

    val TAG = "AddTeacher"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_add_teacher, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        saveButton.setOnClickListener {
            val name =  this.teacherName.text.toString();
            val surname = this.teacherSurname.text.toString();
            val phoneNumber = this.teacherPhone.text.toString();

            val dbHelper = ScheduleAssistantDbHelper(this.context!!)

            // Gets the data repository in write mode
            val db = dbHelper.writableDatabase

// Create a new map of values, where column names are the keys
            val values = ContentValues().apply {
                put(TeacherContract.TeacherEntry.COLUMN_NAME_NAME, name)
                put(TeacherContract.TeacherEntry.COLUMN_NAME_SURNAME, surname)
                put(TeacherContract.TeacherEntry.COLUMN_NAME_PHONE, phoneNumber)
            }

// Insert the new row, returning the primary key value of the new row
            val newRowId = db?.insert(TeacherContract.TeacherEntry.TABLE_NAME, null, values)
            Log.i(TAG, "save:" + name + surname + phoneNumber)
            Log.i(TAG, "save")
        }

        readButton.setOnClickListener {
            val dbHelper = ScheduleAssistantDbHelper(this.context!!)

            val db = dbHelper.readableDatabase

// Define a projection that specifies which columns from the database
// you will actually use after this query.
            val projection = arrayOf(BaseColumns._ID,
                TeacherContract.TeacherEntry.COLUMN_NAME_NAME,
                TeacherContract.TeacherEntry.COLUMN_NAME_SURNAME,
                TeacherContract.TeacherEntry.COLUMN_NAME_PHONE)

// Filter results WHERE "title" = 'My Title'
//            val selection = "${FeedEntry.COLUMN_NAME_TITLE} = ?"
//            val selectionArgs = arrayOf("My Title")

// How you want the results sorted in the resulting Cursor
            val sortOrder = "${TeacherContract.TeacherEntry.COLUMN_NAME_NAME} DESC"

            val cursor = db.query(
                TeacherContract.TeacherEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,//selection,              // The columns for the WHERE clause
                null,//selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
            )
            while (cursor.moveToNext()) {
                Log.i(
                    TAG, "###" +
                            cursor.getString(0) + "||" +
                            cursor.getString(1) + "||" +
                            cursor.getString(2) + "||" +
                            cursor.getString(3)
                )
            }
        }
    }
}
