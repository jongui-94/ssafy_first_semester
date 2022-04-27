package com.ssafy.gallery

import android.content.Context
import androidx.room.Room
import com.ssafy.gallery.database.GalleryDatabase


// GalleryRepository는 싱글톤 (앱이 실행 되는 동안 하나의 인스턴스만 생성)
private const val DATABASE_NAME = "gallery-database"
class GalleryRepository private constructor(context: Context) {

    private val database: GalleryDatabase = Room.databaseBuilder(
        context.applicationContext,
        GalleryDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val galleryDao = database.galleryDao()

    suspend fun getPhotos(): List<Photo> = galleryDao.getPhotos()
    suspend fun getPhoto(id: Long): Photo = galleryDao.getPhoto(id)
    suspend fun insert(photo: Photo) = galleryDao.insert(photo)

    companion object {
        private var INSTANCE: GalleryRepository? = null

         fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = GalleryRepository(context)
            }
        }

        fun get(): GalleryRepository {
            return INSTANCE ?:
            throw IllegalStateException("GalleryRepository must be initialized")
        }
    }
}