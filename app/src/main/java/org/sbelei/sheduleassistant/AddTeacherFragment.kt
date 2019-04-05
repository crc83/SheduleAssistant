package org.sbelei.sheduleassistant

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_add_teacher.*
import kotlinx.android.synthetic.main.fragment_add_teacher.view.*

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
            Log.i(TAG, "save:" + name + surname + phoneNumber)
            Log.i(TAG, "save")
        }
    }
}
