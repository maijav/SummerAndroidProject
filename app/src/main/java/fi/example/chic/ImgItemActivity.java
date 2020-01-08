package fi.example.chic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ImgItemActivity extends AppCompatActivity {

    private TextView tvTitle, tvDesc, tvCat;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inside_of_card);

        tvDesc = (TextView) findViewById(R.id.txtdesc);
        img = (ImageView) findViewById(R.id.itemthumbnail);

        //Receiving data

        Intent intent = getIntent();
        String description = intent.getExtras().getString("fi.example.chic.description");
        Uri image = Uri.parse(getIntent().getExtras().getString("fi.example.chic.thumbnail"));

        tvDesc.setText(description);
        img.setImageURI(image);
    }
}
