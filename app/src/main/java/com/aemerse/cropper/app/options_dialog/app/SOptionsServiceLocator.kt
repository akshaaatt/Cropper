package com.aemerse.cropper.app.options_dialog.app

import android.content.Context
import com.aemerse.cropper.app.options_dialog.domain.SOptionsContract
import com.aemerse.cropper.app.options_dialog.presenter.SOptionsPresenter

internal class SOptionsServiceLocator(private val context: Context) {

    fun getPresenter(): SOptionsContract.Presenter = SOptionsPresenter()
}
