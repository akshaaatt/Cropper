package com.aemerse.cropper.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.aemerse.cropper.app.crop_image.app.SCropImageFragment
import com.aemerse.cropper.app.crop_image_view.app.SCropImageViewFragment
import com.aemerse.cropper.app.extend_activity.app.SExtendActivity
import com.aemerse.cropper.app.databinding.ActivityMainBinding

internal class SMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.sampleCropImageView.setOnClickListener {
            SCropImageViewFragment.newInstance().show()
        }

        binding.sampleCustomActivity.setOnClickListener {
            SExtendActivity.start(this)
        }

        binding.sampleCropImage.setOnClickListener {
            SCropImageFragment.newInstance().show()
        }
    }

    private fun Fragment.show() {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id, this)
            .commit()
    }

    override fun onBackPressed() {
        supportFragmentManager.findFragmentById(binding.container.id)?.apply {
            supportFragmentManager.beginTransaction().remove(this).commit()
            return
        }
        super.onBackPressed()
    }
}
