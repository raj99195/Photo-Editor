package com.example.photoeditor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.photoeditor.databinding.ActivityFinalBinding;

public class FinalActivity extends AppCompatActivity {


    ActivityFinalBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityFinalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);

        dsPhotoEditorIntent.setData(MainActivity.imgUri);


        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "My Editor");


//        int[] toolsToHide = {DsPhotoEditorActivity.TOOL_ORIENTATION, DsPhotoEditorActivity.TOOL_CROP};
//
//        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);
//


        startActivityForResult(dsPhotoEditorIntent, 200);








    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            if (requestCode == 200) {
                Uri outputUri = data.getData();

                // handle the result uri as you want, such as display it in an imageView;

                binding.imageView3.setImageURI(outputUri);
            }

        }


    }
}