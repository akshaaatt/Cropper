package com.aemerse.cropper.app.options_dialog.domain

import com.aemerse.cropper.CropImageView.CropShape
import com.aemerse.cropper.CropImageView.Guidelines
import com.aemerse.cropper.CropImageView.ScaleType

internal interface SOptionsContract {

    interface View {
        fun updateOptions(options: SOptionsDomain)
        fun closeWithResult(options: SOptionsDomain)
    }

    interface Presenter {
        fun bind(view: View)
        fun unbind()
        fun onViewCreated(options: SOptionsDomain?)
        fun onDismiss()
        fun onScaleTypeSelect(scaleType: ScaleType)
        fun onCropShapeSelect(cropShape: CropShape)
        fun onGuidelinesSelect(guidelines: Guidelines)
        fun onRatioSelect(ratio: Pair<Int, Int>?)
        fun onAutoZoomSelect(enable: Boolean)
        fun onMaxZoomLvlSelect(maxZoom: Int)
        fun onMultiTouchSelect(enable: Boolean)
        fun onCenterMoveSelect(enable: Boolean)
        fun onCropOverlaySelect(show: Boolean)
        fun onProgressBarSelect(show: Boolean)
        fun onFlipHorizontalSelect(enable: Boolean)
        fun onFlipVerticallySelect(enable: Boolean)
    }
}
