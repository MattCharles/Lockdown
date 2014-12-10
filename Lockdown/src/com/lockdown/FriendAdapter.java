package com.lockdown;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * An Adapter that takes Role objects and maps them to a ListView
 */
public class FriendAdapter extends ArrayAdapter<Friend> {
	private ArrayList<Friend> entries;
    private Context context;
 
    public FriendAdapter(Context context, int textViewResourceId, ArrayList<Friend> entries) {
        super(context, textViewResourceId, entries);
        this.entries = entries;
        this.context = context;
    }
 
    /**
     * An item in the ListView
     */
    public static class ViewHolder{
        public TextView item1;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        View v = convertView;
//        ViewHolder holder;
//        if (v == null) {
//            LayoutInflater vi =
//                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            v = vi.inflate(android.R.layout.simple_spinner_item, null);
//            holder = new ViewHolder();
//            holder.item1 = (TextView) v.findViewById(android.R.id.text1);
//            v.setTag(holder);
//        }
//        else
//            holder=(ViewHolder)v.getTag();
// 
//        final Role role = entries.get(position); // get Role
//        if (role != null) {
//        	// set ListView values
//            holder.item1.setText(role.getId().toString());
//        }
    	TextView label = new TextView(context);
    	label.setPadding(20, 20, 20, 20);
    	label.setTextColor(Color.BLACK);
    	final Friend friend = entries.get(position);
        label.setText(friend.getName());
        return label;
    }
    
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
    	TextView label = new TextView(context);
    	label.setPadding(30, 30, 30, 30);
    	label.setTextColor(Color.BLACK);
    	final Friend friend = entries.get(position);
        label.setText(friend.getName());
        return label;
    }

}