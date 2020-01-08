package fi.example.chic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//This is the item adapter for the start activity.
//This file adapts the layout for an individual list element to the list layout of the start activity.

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] items;
    Resources res;


    public ItemAdapter (Context c, String[] i){
        items = i;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        res = c.getResources();
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflater.inflate(R.layout.categorylist_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        ImageView categoryImg = (ImageView) v.findViewById(R.id.categoryImg);

        String name = items[i];

        nameTextView.setText(name);

        int pic = getImg(i);
        Bitmap imgBitmap = BitmapFactory.decodeResource(res,pic);
        categoryImg.setImageBitmap(imgBitmap);

        return v;

    }

    private int getImg (int index){
        switch (index){
            case 0: return R.drawable.sunny4;
            case 1: return R.drawable.fall1;
            case 2: return R.drawable.wintery1;
            default: return -1;
        }
    }

}