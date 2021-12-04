package com.aemerse.cropper.app.crop_image_view.domain

import com.aemerse.cropper.app.options_dialog.domain.SOptionsDomain

internal interface SCropImageViewContract {
    fun interface View {
        fun setOptions(options: SOptionsDomain)
    }

    interface Presenter {
        fun bind(view: View)
        fun unbind()
        fun onViewCreated()
    }
}
