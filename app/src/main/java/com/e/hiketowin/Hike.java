package com.e.hiketowin;

import java.io.Serializable;

public class Hike implements Serializable {

    private String key;
    private String timeSpent;
    private String distance;
    private String trailName;
    private String latitude;
    private String longitude;

    public Hike (String key, String trailName) {
        this.key = key;
        this.trailName = trailName;
    }

}
