package com.aemerse.cropper.app.extend_activity.domain

internal interface SExtendContract {
    interface View {
        fun updateRotationCounter(counter: String)
        fun rotate(counter: Int)
    }

    interface Presenter {
        fun bindView(view: View)
        fun unbindView()
        fun onRotateClick()
    }
}
