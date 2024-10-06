package com.example.lab04;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.teamNameField), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void OnOpenInGoogleMaps(View view) {
        EditText teamAddress = (EditText) findViewById(R.id.teamAddressField);
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    public void OnSetAvatarButton(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
        startActivityForResult(intent,0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView avatarImage = (ImageView)
                findViewById(R.id.avatarImage);
        String drawableName = "avatar1";
        switch (data.getIntExtra("selectedImageId", R.id.imageView)) {
            case R.id.imageView:
                drawableName = "ic_logo_01.png";
                break;
            case R.id.imageView2:
                drawableName = "ic_logo_02.png";
                break;
            case R.id.imageView3:
                drawableName = "ic_logo_03.png";
                break;
            case R.id.imageView4:
                drawableName = "ic_logo_04.png";
                break;
            case R.id.imageView5:
                drawableName = "ic_logo_05.png";
                break;
            case R.id.imageView6:
                drawableName = "ic_logo_00.png";
                break;
            default:
                drawableName = "ic_logo_01.png";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable",
                getPackageName());
        avatarImage.setImageResource(resID);
    }

}