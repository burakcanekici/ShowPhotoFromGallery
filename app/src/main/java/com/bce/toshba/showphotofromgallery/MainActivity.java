package com.bce.toshba.showphotofromgallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        ImageView iv1 = (ImageView) findViewById(R.id.photo1);
        ImageView iv2 = (ImageView) findViewById(R.id.photo2);
        ArrayList<ImageView> ivList = new ArrayList<ImageView>();
        ivList.add(iv1);
        ivList.add(iv2);

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if (type.startsWith("image/")) {
                //Handle one image from gallery
                Uri imageUri = (Uri) intent.getParcelableExtra(intent.EXTRA_STREAM);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                iv1.setImageBitmap(bitmap);
            }
        } else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("image/")) {
                //Handle share multiple image from gallery
                ArrayList<Uri> imageUris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
                if(imageUris != null && imageUris.size() > 0){
                    for (int i=0;i<imageUris.size();i++){
                        Bitmap bitmap = null;
                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUris.get(i));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ivList.get(i).setImageBitmap(bitmap);
                    }
                }
            }
        }
    }
}
