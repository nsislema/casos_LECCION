package com.edu.casos;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.edu.casos.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    public static final int PHOTO_REQUEST_CODE = 1000;
    private ActivityMainBinding binding;
    private Bitmap takenPhotoBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.saveButton.setOnClickListener(view -> {
            String superheroName = binding.heroNameEdit.getText().toString();
            String alertEgo = binding.alterEgoEdit.getText().toString();
            String bio = binding.bioEdit.getText().toString();
            float rating = binding.powerBar.getRating();
            OpenDetailActivity(superheroName, alertEgo, bio, rating);
        });
        binding.heroImage.setOnClickListener(view -> {
            openCamara();
        });
    }

    private void openCamara() {
        Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camaraIntent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode ==
                PHOTO_REQUEST_CODE) {
            if (data != null) {
                takenPhotoBitmap = data.getExtras().getParcelable("data");
                binding.heroImage.setImageBitmap(takenPhotoBitmap);
            } else {
                Toast.makeText(this, "Error taking photo",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void OpenDetailActivity(String superheroName, String
            alertEgo, String bio, float rating) {
        SuperTema caso = new SuperTema(superheroName, alertEgo, bio, rating);
        Intent intent = new Intent(this, DetailActivity.class);
        // intent.putExtra("superhero_Name",superheroName);
        // intent.putExtra("alert_Ego",alertEgo);
        // intent.putExtra("bio",bio);
        // intent.putExtra("rating",rating);
        intent.putExtra(DetailActivity.SUPERTEMA_KEY, caso);
        startActivity(intent);
    }
}
