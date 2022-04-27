package com.ssafy.gallery

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.SQLException

class GalleryDao {
    private val DATABASE_TABLE = "photos"
    private val NUM = "num"
    private val PHOTO_LOCATION = "photoLocation"
    private val PHOTO_DATE = "photoDate"
    private val PHOTO_SRC = "photoSrc"

    // DB선언부
    lateinit var helper: DBHelper
    lateinit var sqlDB: SQLiteDatabase
    private var mCtx: Context? = null

    // INSERT
    fun insertPhoto(dto: Photo): Long {
        val args = ContentValues()
        args.put(PHOTO_LOCATION, dto.location)
        args.put(PHOTO_DATE, dto.date)
        args.put(PHOTO_SRC, dto.src)

        return sqlDB.insert(DATABASE_TABLE, null, args)
    }

    // SELECT
    fun selectAllPhotos(): MutableList<Photo> {
        val list = mutableListOf<Photo>()
        sqlDB.rawQuery("SELECT $NUM, $PHOTO_LOCATION, $PHOTO_DATE, $PHOTO_SRC FROM $DATABASE_TABLE",null).use {
            if(it.moveToFirst()) {
                do {
                    list.add(Photo(it.getInt(0), it.getString(1), it.getLong(2), it.getString(3)))
                } while (it.moveToNext())
            }
        }
        return list
    }

    fun selectPhotos(num: Int): Photo {
        sqlDB.rawQuery("SELECT $NUM, $PHOTO_LOCATION, $PHOTO_DATE, $PHOTO_SRC FROM $DATABASE_TABLE WHERE $NUM = ?", arrayOf(num.toString())).use{
            it.moveToFirst()
            return Photo(it.getInt(0), it.getString(1), it.getLong(2), it.getString(3))
        }
    }

    @Throws(SQLException::class)
    fun open() {
        helper = DBHelper(mCtx!!)
        sqlDB = helper.writableDatabase
    }
    fun dbOpenHelper(context: Context) {
        this.mCtx = context
    }
    fun create() {
        // DB생성
        helper.onCreate(sqlDB)
    }
    fun upgrade(oldVersion: Int, newVersion: Int) {
        // DB version 변경
        helper.onUpgrade(sqlDB, 1, 2)
    }
    fun close() {
        // DB종료
        sqlDB.close()
    }

    inner class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_TABLE, null, 1) {

        override fun onCreate(p0: SQLiteDatabase?) { //테이블 생성
            p0!!.execSQL("CREATE TABLE $DATABASE_TABLE ( $NUM INTEGER PRIMARY KEY AUTOINCREMENT, $PHOTO_LOCATION CHAR(200) , $PHOTO_DATE CHAR(200), $PHOTO_SRC long);")
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) { //테이블 삭제 후 생성
            p0!!.execSQL("DROP TABLE IF EXISTS  $DATABASE_TABLE")
            onCreate(p0)
        }
    }
}