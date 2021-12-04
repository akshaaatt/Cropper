package com.aemerse.cropper.app.crop_image_view.presenter

import com.aemerse.cropper.CropImageView
import com.aemerse.cropper.app.crop_image_view.domain.SCropImageViewContract
import com.aemerse.cropper.app.options_dialog.domain.SOptionsDomain

internal class SCropImageViewPresenter : SCropImageViewContract.Presenter {

    private var view: SCropImageViewContract.View? = null

    override fun bind(view: SCropImageViewContract.View) {
        this.view = view
    }

    override fun unbind() {
        view = null
    }

    override fun onViewCreated() {
        view?.setOptions(getOptions())
    }

    private fun getOptions(): SOptionsDomain = SOptionsDomain(
        CropImageView.ScaleType.FIT_CENTER,
        CropImageView.CropShape.RECTANGLE,
        CropImageView.Guidelines.ON,
        Pair(1, 1),
        autoZoom = true,
        maxZoomLvl = 2,
        multiTouch = true,
        centerMove = true,
        showCropOverlay = true,
        showProgressBar = true,
        flipHorizontal = false,
        flipVertically = false
    )
}
