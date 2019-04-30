package com.e.hiketowin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class HikeAdapter extends ArrayAdapter<Hike> {

    private List<Hike> hikeList;            // The list of fish to display
    private Context context;                // The original activity that displays this
    private int layoutResource;                   // the layout to use

    public HikeAdapter(Context context, int resource, List<Hike> hikeList) {
        super(context, resource, hikeList);
        this.context = context;
        this.layoutResource = resource;
        this.hikeList = hikeList;
    }


}
