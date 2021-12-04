[![](https://jitpack.io/v/akshaaatt/Cropper.svg)](https://jitpack.io/#akshaaatt/Cropper)

Android Image Cropper
=======
**Powerful** (Zoom, Rotation, Multi-Source);
**Customizable** (Shape, Limits, Style);
**Optimized** (Async, Sampling, Matrix);
**Simple** image cropping library for Android.

# Add to your project

### Step 1. Add the JitPack repository to your root build.gradle

```gradle
  allprojects {
     repositories {
       ....
       maven { url 'https://jitpack.io' }
     }
  }
```

### Step 2. Add the dependency

```gradle
  dependencies {
       implementation 'com.github.akshaaatt:Cropper:1.0.0'
  }
```

# Using the Library
There is 3 ways of using the library:
- Calling crop directly (Sample code: `app/crop_image`)
- Using the CropView (Sample code: `app/crop_image_view`)
- Extending the activity (Sample code: `app/extend_activity`)
Your choice depends on how you want your layout to look.

Obs: The library has a public pick image contract, more on wiki.

## Calling crop directly
- Register for activity result with `CropImageContract`
 ```kotlin
class MainActivity {
    private val cropImage = registerForActivityResult(CropImageContract()) { result ->
            if (result.isSuccessful) {
                // use the returned uri
                val uriContent = result.uriContent 
                val uriFilePath = result.getUriFilePath(context) // optional usage
            } else {
                // an error occurred
                val exception = result.error
            }
        }

    private fun startCrop() {
        // start picker to get image for cropping and then use the image in cropping activity
        cropImage.launch(
            options {
                setGuidelines(Guidelines.ON)
            }
        )

        //start picker to get image for cropping from only gallery and then use the image in
        //cropping activity
        cropImage.launch(
            options {
                setImagePickerContractOptions(
                    PickImageContractOptions(includeGallery = true, includeCamera = false)
                )
            }
        )

        // start cropping activity for pre-acquired image saved on the device and customize settings
        cropImage.launch(
            options(uri = imageUri) {
                setGuidelines(Guidelines.ON)
                setOutputCompressFormat(CompressFormat.PNG)
            }
        )
    }
}
 ```

## Using CropView
2. Add `CropImageView` into your activity
 ```xml
 <!-- Image Cropper fill the remaining available height -->
 <com.aemerse.cropper.CropImageView
   android:id="@+id/cropImageView"
   android:layout_width="match_parent"
   android:layout_height="0dp"
   android:layout_weight="1"/>
 ```

3. Set image to crop
 ```kotlin
 cropImageView.setImageUriAsync(uri)
 // or (prefer using uri for performance and better user experience)
 cropImageView.setImageBitmap(bitmap)
 ```

4. Get cropped image
 ```kotlin
 // subscribe to async event using cropImageView.setOnCropImageCompleteListener(listener)
 cropImageView.getCroppedImageAsync()
 // or
 val cropped: Bitmap = cropImageView.getCroppedImage()
 ```

## Extend to make a custom activity
If you want to extend the `CropImageActivity` please be aware you will need to setup your `CropImageView`
You can check a sample code in this project `com.aemerse.cropper.app.extend_activity.app.SExtendActivity`

- Add `CropImageActivity` into your AndroidManifest.xml
 ```xml
 <activity android:name="com.aemerse.cropper.CropImageActivity"
   android:theme="@style/Base.Theme.AppCompat"/> <!-- optional (needed if default theme has no action bar) -->
 ```
- Setup your `CropImageView` after call `super.onCreate(savedInstanceState)`
 ```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setCropImageView(binding.cropImageView)
}
 ```

### Custom dialog for image source pick
When calling crop directly the library will prompt a dialog for the user choose between gallery or camera (If you keep both enable).
We use the Android default AlertDialog for this. If you wanna customised it with your app theme you need to override the method `showImageSourceDialog(..)` when extending the activity _(above)_
```kotlin 
override fun showImageSourceDialog(openSource: (Source) -> Unit) {
     super.showImageSourceDialog(openCamera)
}
```

## Features
- Built-in `CropImageActivity`.
- Set cropping image as Bitmap, Resource or Android URI (Gallery, Camera, Dropbox, etc.).
- Image rotation/flipping during cropping.
- Auto zoom-in/out to relevant cropping area.
- Auto rotate bitmap by image Exif data.
- Set result image min/max limits in pixels.
- Set initial crop window size/location.
- Request cropped image resize to specific size.
- Bitmap memory optimization, OOM handling (should never occur)!
- API Level 14.
- More..

## Customizations
- Cropping window shape: Rectangular, Oval (square/circle by fixing aspect ratio), as well as
 rectangular modes which only allow vertical or horizontal cropping.
- Cropping window aspect ratio: Free, 1:1, 4:3, 16:9 or Custom.
- Guidelines appearance: Off / Always On / Show on Touch.
- Cropping window Border line, border corner and guidelines thickness and color.
- Cropping background color.
