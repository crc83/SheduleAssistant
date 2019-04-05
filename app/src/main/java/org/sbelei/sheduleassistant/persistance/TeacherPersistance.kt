package org.sbelei.sheduleassistant.persistance

import android.provider.BaseColumns

object TeacherContract {
    //example taken from here : https://developer.android.com/training/data-storage/sqlite

    // Table contents are grouped together in an anonymous object.
    object TeacherEntry : BaseColumns {
        const val TABLE_NAME = "teachers"
        const val COLUMN_NAME_NAME = "name"
        const val COLUMN_NAME_SURNAME = "surname"
        const val COLUMN_NAME_PHONE = "phone"
    }

    const val SQL_CREATE_TABLE =
        "CREATE TABLE ${TeacherEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${TeacherEntry.COLUMN_NAME_NAME} TEXT," +
                "${TeacherEntry.COLUMN_NAME_SURNAME} TEXT," +
                "${TeacherEntry.COLUMN_NAME_PHONE} TEXT)"

    //removed. we will have proper update policy
    //private const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS ${TeacherEntry.TABLE_NAME}"
}