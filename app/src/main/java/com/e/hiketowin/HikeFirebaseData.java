package com.e.hiketowin;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HikeFirebaseData {

    DatabaseReference myHikeDbRef;
    public static final String HikeDataTag = "Hike Data";


    public DatabaseReference open()  {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myHikeDbRef = database.getReference(HikeDataTag);
        return myHikeDbRef;
    }

    public Hike createFish( String trailName) {           //Added String rating as a parameter
        // ---- Get a new database key for the vote
        String key = myHikeDbRef.child(HikeDataTag).push().getKey();
        // String key = "REPLACE THIS WITH KEY FROM DATABASE";
        // ---- set up the fish object
        Hike newHike = new Hike(key, trailName);
        // ---- write the vote to Firebase
        myHikeDbRef.child(key).setValue(newHike);
        return newHike;
    }


    public List<Hike> getAllHikes(DataSnapshot dataSnapshot) {
        List<Hike> hikeList = new ArrayList<Hike>();
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Hike hike = data.getValue(Hike.class);
            hikeList.add(hike);
        }
        return hikeList;
    }
}
