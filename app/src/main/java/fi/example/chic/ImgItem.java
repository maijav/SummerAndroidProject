package fi.example.chic;

import android.net.Uri;

public class ImgItem {

    private String Description;
    private String Thumbnail;

    public ImgItem() {
    }

    public ImgItem(String description, String thumbnail) {
        Description = description;
        Thumbnail = thumbnail;
    }


    public String getDescription() {
        return Description;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }
}
