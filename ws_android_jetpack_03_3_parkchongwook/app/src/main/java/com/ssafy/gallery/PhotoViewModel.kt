package com.ssafy.gallery

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter

// 레이아웃이 홀더 함수 내부에서 PhotoViewModel의 Photo 객체를 변경했음을 알 수 있는 방법이 없기 때문에
// 바인딩 데이터가 변경되었을 때 뷰모델이 레이아웃 파일과 소통하게 만든다.
private const val TAG = "PhotoViewModel_싸피"
class PhotoViewModel : BaseObservable() {
    var photo: Photo? = null
        set(photo) {
            field = photo
            notifyChange()
        }

    @get:Bindable
    val src: String?
        get() = photo?.src
}

// 일반적인 방법으로 ImageSrc를 넘기면 사진이 나오지 않는다.
// 다음과 같이 BindingAdapter를 생성하여 넘겨주어야 한다.
// layout 파일에서는
// app:imageUrl="@{viewModel.src}"
// 과 같이 사용한다.
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Log.d(TAG, "loadImage: $view, $url")

    val packageName = "com.ssafy.gallery"

    // url 파라메터에서 null을 허용하지 않으면 강제종료되는 문제로 인해 null 허용하도록 수정
    // 그 이후에 url 값이 null인 경우에 대비하여 아래와 같이 if문으로 null 체크
    // null이 넘어오는 이유는 찾지 못함
    if (url != null) {
        val resId = view.resources.getIdentifier(url, "drawable", packageName)
        view.setImageResource(resId)
    }
}
