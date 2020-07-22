package com.example.pickgalleryimage

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    // initialise the button and the view
    lateinit var pickBtn : Button
    lateinit var imgView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find the button and view
        pickBtn = findViewById(R.id.pickImgBtn)
        imgView = findViewById(R.id.imageView)

        // initiate intent on button action
        pickBtn.setOnClickListener {
            //Intent to pick image
            val myIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            startActivityForResult(myIntent,9999)
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 9999){
            imgView.setImageURI(data?.data)
        }
    }
}

