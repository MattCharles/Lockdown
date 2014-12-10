package com.lockdown;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

public class NewLockActivity extends ActionBarActivity {

	private EditText title;
	private TimePicker timePicker;
	private Friends friendlist; 
	FriendAdapter friendAdapter1;
	FriendAdapter friendAdapter2;
	FriendAdapter friendAdapter3;
	private Spinner contact1Spinner;
	private Spinner contact2Spinner;
	private Spinner contact3Spinner;
	private Button saveButton;
	private int hour;
	private int minute;
	String lockTitle;
	Friend friend1, friend2, friend3;
	String name1 = "";
	String name2 = "";
	String name3 = "";
	static final int TIME_DIALOG_ID = 999;
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_lock);

	/*	if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
*/		title = (EditText) findViewById(R.id.title);
		timePicker = (TimePicker) findViewById(R.id.timePicker);
		saveButton=(Button)findViewById(R.id.save_button);  
        contact1Spinner = (Spinner) findViewById(R.id.contact1Spinner);
        contact2Spinner = (Spinner) findViewById(R.id.contact2Spinner);
        contact3Spinner = (Spinner) findViewById(R.id.contact3Spinner);
    	contact1Spinner.setEnabled(true);
	 	contact2Spinner.setEnabled(true);
		contact3Spinner.setEnabled(true);
        
        friendlist = new Friends();
    	
    	friendlist.addFriend(new Friend("Matt"));
    	friendlist.addFriend(new Friend("Emma"));
    	friendlist.addFriend(new Friend("Claire"));
    	friendlist.addFriend(new Friend("Dan"));
    	friendlist.addFriend(new Friend("Ted"));
    	friendlist.addFriend(new Friend("Molly"));
    	
        
	 //  setSpinners();
       updateViews();
      // setSpinners();
       
          
/*        saveButton.setOnClickListener(new OnClickListener(){  
            @Override  
            public void onClick(View view) {  
                 title.setText(getCurrentTime());  
            }  
        });  
*/	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_lock, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_new_lock,
					container, false);
			return rootView;
		}
	}
	
	 public String getCurrentTime(){  
		    String time = "";
		    time = time + getTimeString(getHour());
		    time = time + ":";
		    time = time + getTimeString(getMinute());
	        String currentTime="Current Time: " + time;
	        return currentTime;  
	    }  
	 
	 public int getHour() {
		 int hours = timePicker.getCurrentHour();
		 return hours;
	 }
	 public int getMinute() {
		 int minutes = timePicker.getCurrentMinute();
		 return minutes;
	 }
	 public String getTimeString( int i ) {
		 String time = "";
		 if ( i < 10 ){  time = time + "0";  }
		 time = time + i;
		 return time;
	 }

	 
	 public void loadFriends() {
		 ArrayList<Friend> FriendList = friendlist.getFriends();
/*		friendAdapter1 = new FriendAdapter(getApplicationContext(), R.id.contact1Spinner, FriendList);
		friendAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	 	contact1Spinner.setAdapter(friendAdapter1);
	 	friendAdapter2 = new FriendAdapter(getApplicationContext(), R.id.contact2Spinner, FriendList);
		friendAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	 	contact2Spinner.setAdapter(friendAdapter2);
	 	friendAdapter3 = new FriendAdapter(getApplicationContext(), R.id.contact3Spinner, FriendList);
		friendAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	 	contact3Spinner.setAdapter(friendAdapter3);
*/	 	
	 	friendAdapter1 = new FriendAdapter(getApplicationContext(), R.id.contact1Spinner, FriendList);
		friendAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	contact1Spinner.setAdapter(friendAdapter1);
    	if(!name1.equals("")){
		 	for(int i = 0; i < friendAdapter1.getCount(); i++) {
	    		if(friendAdapter1.getItem(i).getName().equals(name1)) {
	    			contact1Spinner.setSelection(i);
	    			break;
	    		}
	    	}
    	}
	 	
    	
    	friendAdapter2 = new FriendAdapter(getApplicationContext(), R.id.contact2Spinner, FriendList);
		friendAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	contact2Spinner.setAdapter(friendAdapter2);
    	if(!name2.equals("")){
		 	for(int i = 0; i < friendAdapter2.getCount(); i++) {
	    		if(friendAdapter2.getItem(i).getName().equals(name2)) {
	    			contact2Spinner.setSelection(i);
	    			break;
	    		}
	    	}
    	}
    	
    	friendAdapter3 = new FriendAdapter(getApplicationContext(), R.id.contact3Spinner, FriendList);
		friendAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	contact3Spinner.setAdapter(friendAdapter1);
    	if(!name3.equals("")){
		 	for(int i = 0; i < friendAdapter3.getCount(); i++) {
	    		if(friendAdapter3.getItem(i).getName().equals(name3)) {
	    			contact3Spinner.setSelection(i);
	    			break;
	    		}
	    	}
    	}
/*	 	
	 	if(!name1.equals("")){
		 	for(int i = 0; i < friendAdapter1.getCount(); i++) {
		    		if(((String)friendAdapter1.getItem(i).getName()).equals(name1)) {
		    			contact1Spinner.setSelection(i);
		    			break;
		    		}
		 	}
	 	}
	 	if(!name2.equals("")){
		 	for(int i = 0; i < friendAdapter2.getCount(); i++) {
		    		if(((String)friendAdapter2.getItem(i).getName()).equals(name2)) {
		    			contact2Spinner.setSelection(i);
		    			break;
		    		}
		 	}
	 	}
		if(!name3.equals("")){
		    for(int i = 0; i < friendAdapter3.getCount(); i++) {
		    		if(((String)friendAdapter3.getItem(i).getName()).equals(name3)) {
		    			contact3Spinner.setSelection(i);
		    			break;
		    		}
		 	}
		}
*/	 	
	 	contact1Spinner.setEnabled(true);
	 	contact2Spinner.setEnabled(true);
		contact3Spinner.setEnabled(true);
	 }

	 
	/**
	 * 	A method to s	public void onItemSelected(AdapterView<?> parent, View view, 
	            int pos, long id) {
			switch(  )
		}tart the new-lock activity when the button is pressed
	 */
	public void saveLock( View view ) {
			 //TODO: send user to complete lock creation
			int minutes = getMinute();
			int hours = getHour();
			lockTitle=title.getText().toString();
		//	name1 = (String) contact1Spinner.getSelectedItem();
		//	name2 = (String) contact1Spinner.getSelectedItem();
		//	name3 = (String) contact1Spinner.getSelectedItem();
			 Intent intent = new Intent(this, LockScreenActivity.class);
			 String keyIdentifer  = null;
			 intent.putExtra("LOCK_TITLE", lockTitle);
			 intent.putExtra("LOCK_HOURS", hours);
			 intent.putExtra("LOCK_MINUTES", minutes);
			 startActivity(intent);
	}

	public void updateViews() {
		//new ListRole(EditFriendActivity.this, this).execute();
		loadFriends();
		title.setText(lockTitle);
	    timePicker.setIs24HourView(true);  
	}
	
	public void setSpinners(){
		contact1Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		    	name1 = (String)parent.getItemAtPosition(pos);
		        friend1 = friendlist.getFriendByName( name1);
		    }
		    public void onNothingSelected(AdapterView<?> parent) {
		    }
		});
		
		contact2Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		    	name2 = (String)parent.getItemAtPosition(pos);
		    	friend2 = friendlist.getFriendByName( name2 );
		    }
		    public void onNothingSelected(AdapterView<?> parent) {
		    }
		});
		
		contact3Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		    	name3 = (String)parent.getItemAtPosition(pos);
		    	friend3 = friendlist.getFriendByName( name3 );
		    }
		    public void onNothingSelected(AdapterView<?> parent) {
		    }
		});
	}
}
