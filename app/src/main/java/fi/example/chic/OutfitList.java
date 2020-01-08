package fi.example.chic;

import java.util.ArrayList;
import java.util.List;

public class OutfitList {
    private static OutfitList mInstance= null;

    public List<ImgItem> outfitlist = new ArrayList<>();

    protected OutfitList(){}

    public static synchronized OutfitList getInstance() {
        if(null == mInstance){
            mInstance = new OutfitList();
        }
        return mInstance;
    }
}
