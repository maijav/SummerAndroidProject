package fi.example.chic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ListView myList;
    String[] items;
    List<ImgItem> outfitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Here we are creating the start activity list (of categories)
        Resources res = getResources();
        myList = (ListView) findViewById(R.id.MyList);
        items = res.getStringArray(R.array.items);

        ImageButton addButton = (ImageButton) findViewById(R.id.addButton);

        ItemAdapter itemAdapter = new ItemAdapter(this, items);
        myList.setAdapter(itemAdapter);

        //Clicking one of the list items takes user to recycle view (card view)
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showCategory = new Intent(getApplicationContext(),RecyclerView_Summer.class);
                startActivity(showCategory);

            }
        });

        //User can add new outfits by clicking the button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addNewOutfit = new Intent(getApplicationContext(), AddNewOutfit.class);
                startActivity(addNewOutfit);
            }
        });
    }


}
