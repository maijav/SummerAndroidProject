package fi.example.chic;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddNewOutfit extends AppCompatActivity {

    ImageView usersPhoto;
    ImageButton summerButton;
    EditText notesEditText;
    static int PReqCode = 1;
    static int RequestCode = 1;
    static Uri pickedImgUri;

    //This is the view where the user picks an image from phone gallery, adds notes and sends to the card view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_outfit_layout);

        usersPhoto = (ImageView) findViewById(R.id.usersPhoto);
        summerButton = (ImageButton) findViewById(R.id.summerButton);
        notesEditText = (EditText) findViewById(R.id.notesEditText);

        //When user clicks photo field, the gallery opens
        usersPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        //When user clicks the summer button, the program sends data to summer recycler view
        summerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pickedImgUri != null){
                    String notes = notesEditText.getText().toString();
                    Intent newIntent = new Intent(getApplicationContext(), RecyclerView_Summer.class);
                    newIntent.putExtra("fi.example.chic.notes", notes);
                    newIntent.putExtra("fi.example.chic.photo", pickedImgUri.toString());
                    startActivity(newIntent);
                }
            }
        });

    }

    private void openGallery() {

        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("Image/*");
        startActivityForResult(galleryIntent, RequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == RequestCode && data != null){
            //the user has picked a suitable image
            //reference to image is saved to a Uri variable

            pickedImgUri = data.getData();
            usersPhoto.setImageURI(pickedImgUri);
        }
    }
}
