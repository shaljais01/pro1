package com.example.pro1;


import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Belal on 9/14/2017.
 */

//we need to extend the ArrayAdapter class as we are building an adapter
public class MyListAdapter extends ArrayAdapter<typeforngo> {

    //the list values in the List of type hero
    List<typeforngo> List;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public MyListAdapter(Context context, int resource, List<typeforngo> List) {
        super(context, resource, List);
        this.context = context;
        this.resource = resource;
        this.List = List;
    }

    //this will return the ListView Item as a View

    @Override
    public View getView(final int position,  View convertView, ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView messname=view.findViewById(R.id.textView_messName);
        TextView location=view.findViewById(R.id.textView_location);
        TextView  quanRoti=view.findViewById(R.id.textView_quanFood);
        TextView quanDal=view.findViewById(R.id.textView_quanDal);



        //getting the hero of the specified position
        typeforngo type = List.get(position);

        //adding values to the list item
        messname.setText(type.getMessName());
        location.setText(type.getLocation());
        quanDal.setText(type.getQuanGravy());
        quanRoti.setText(type.getQuannRoti());



        byte[] decodedString = Base64.decode(type.getPhoto(), Base64.DEFAULT);

        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        imageView.setImageBitmap(decodedByte);

        int s=type.getRating();

        RatingBar r=view.findViewById(R.id.ratingBar);
        r.setRating(s);


        return view;
    }


}