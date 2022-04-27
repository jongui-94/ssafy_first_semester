package com.ssafy.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.ssafy.gallery.database.GalleryDao
import com.ssafy.gallery.databinding.FragmentPhotoBinding
import com.ssafy.gallery.util.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val ARG_PHOTO_ID = "photo_id"
class PhotoFragment : Fragment() {

    private var photo: Photo = Photo()
    private var photoId: Long = 0L
    private val galleryRepository = GalleryRepository.get()
    private lateinit var binding: FragmentPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 넘어온 ID값 받기
        photoId = arguments?.getSerializable(ARG_PHOTO_ID) as Long
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_photo, container, false)
        binding.viewModel = PhotoViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.Main).launch {
            photo = galleryRepository.getPhoto(photoId)
            binding.viewModel?.photo = photo
            updateUI(photo)
        }
    }

    private fun updateUI(photo: Photo) {
        binding.textPhotoLocation.apply {
            text = photo.location
        }

        binding.textPhotoDate.apply {
            val sdf = Utils.formatter().format(photo.date).toString()
            text = sdf
        }
    }

    companion object {
        // Argument에 Bundle을 넘겨 ID 값을 저장하는 Instance 함수 구현
        fun newInstance(photoId: Long): PhotoFragment {
            val args = Bundle().apply {
                putSerializable(ARG_PHOTO_ID, photoId)
            }

            return PhotoFragment().apply {
                arguments = args
            }
        }
    }
}