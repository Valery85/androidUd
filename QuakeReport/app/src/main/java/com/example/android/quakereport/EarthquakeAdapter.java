package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by rik on 8/1/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
//        getLocationData("215km SW of Tomatlan, Mexico");
//        getLocationOffset("215km SW of Tomatlan, Mexico");
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        //Get the object that stored in current position in the list
        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTV = (TextView) listItemView.findViewById(R.id.magnitude);
        String magnitude = getMagnitudeFormated(currentEarthquake.getMagnitude());
        magnitudeTV.setText(magnitude);

//        TextView locationTV = (TextView) listItemView.findViewById(R.id.location);
//        locationTV.setText( " " + currentEarthquake.getLocation());

        TextView locationPrimaryTV = (TextView) listItemView.findViewById(R.id.location_primary);
        String locationPrimary = getLocationData(currentEarthquake.getLocation());
        locationPrimaryTV.setText(locationPrimary);

        TextView locationOffsetTV = (TextView) listItemView.findViewById(R.id.location_offset);
        String locationOffset = getLocationOffset(currentEarthquake.getLocation());
        locationOffsetTV.setText(locationOffset);

        // Create Date object from the time in ms (when earthquake happened)
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // date in human readable format (Jan 10, 2016)
        String formattedDate = formatDate(dateObject);

        TextView dateTV = (TextView) listItemView.findViewById(R.id.date);
        dateTV.setText(formattedDate);

        // time in human readable format (7:10 pm)
        String formattedTime = formatTime(dateObject);

        TextView timeTV = (TextView) listItemView.findViewById(R.id.time);
        timeTV.setText(formattedTime);


        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    // To get primary location by splitting string
    private String getLocationData(String location) {
        String locationData[] = location.split("of ", 2);

//        Log.e("!!!!!EarthquakeAdapter", " : " +  locationData[0] + " of " + "\n" +
//        locationData[1]);

        // Not all raw strings with location have "of " pattern, this caused exceptions
        //because created array contains of 1 element (whole initial string)
        if (locationData.length > 1) {
            return locationData[0] + "of ";
        } else return "Near to";
    }

    private String getLocationOffset(String location) {
        String locationData[] = location.split("of ", 2);
//        Log.e("!!!!!EarthquakeAdapter", " : " +  locationData[0] + " of " + "\n" +
//                locationData[1]);

        // Not all raw strings with  location have "of " pattern, this caused exceptions
        //because created array contains of  1 element (whole initial string) so in primary
        // location I return "Near to" , and here return whole raw string which is zero element
        //in array
        if (locationData.length > 1) {
            return locationData[1];
        } else return locationData[0];


    }
// Get magnitude as a formatted string  (like "1,1") from double magnitude value

    private String getMagnitudeFormated(double magnitude){
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magnitude);

    }

}
