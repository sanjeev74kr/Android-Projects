package com.example.maa;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cook {
    private long id;
    private String cookName;
    private Double rating;
    private String profilePic;
    private String banner;


    public Cook()
    {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        if(rating instanceof Double)
        this.rating =(Double) rating;
        else if(rating instanceof Long)
            this.rating=Double.valueOf((Long)rating);
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}
