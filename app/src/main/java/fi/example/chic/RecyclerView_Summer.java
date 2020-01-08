package fi.example.chic;

//This is the recycler view java file for the first category (summer)

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_Summer extends AppCompatActivity{

    String notes;
    String photo1;
    Uri photo;
    List<ImgItem> outfitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_layout);

        outfitList = new ArrayList<ImgItem>();

        Intent intent = getIntent();
        if(intent.hasExtra("fi.example.chic.notes") && intent.hasExtra("fi.example.chic.photo")){
            notes = intent.getExtras().getString("fi.example.chic.notes");
            photo1 = intent.getExtras().getString("fi.example.chic.photo");

            if(photo1 != null && notes != null) {
                //photo = Uri.parse(photo1);
                //outfitList = OutfitList.getInstance().outfitlist;
                outfitList.add(new ImgItem(notes, photo1));
            }
        }


        RecyclerView myRv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerView_Adapter myAdapter = new RecyclerView_Adapter(this, outfitList);
        myRv.setLayoutManager(new GridLayoutManager(this, 3));
        myRv.setAdapter(myAdapter);
    }
}
