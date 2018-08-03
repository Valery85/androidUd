package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rik on 8/1/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context,0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View listItemView = convertView;
       if(listItemView == null){
           listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
       }

       //Get the object that stored in current position in the list
       Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTV = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeTV.setText( " " + currentEarthquake.getMagnitude());

        TextView locationTV = (TextView) listItemView.findViewById(R.id.location);
        locationTV.setText( " " + currentEarthquake.getLocation());

        TextView dateTV = (TextView) listItemView.findViewById(R.id.date);
        dateTV.setText( " " + currentEarthquake.getTimeInMilliseconds());

        return listItemView;
    }
}
