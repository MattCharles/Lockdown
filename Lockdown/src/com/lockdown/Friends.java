/**
 * 
 */
package com.lockdown;

import java.util.ArrayList;

/**
 * @author Emma
 *
 */
public class Friends {
	ArrayList<Friend> friends;
	public Friends(){
		friends = new ArrayList<Friend>();
	}
	
	public ArrayList<Friend> getFriends(){
		return friends;
	}
	public ArrayList<String> getFriendsNames(){
		ArrayList<String> friendlist = new ArrayList<String>();
		for(Friend i : friends) {
			friendlist.add((String)i.getName());
		}
		return friendlist;
	}
	public void addFriend( Friend friend ){
		friends.add(friend);
	}
	public Friend getFriendByName( String name ){
		for(Friend i : friends) {
			if (i.getName().equals(name))
				return i;
		}
		return null;
	}
	public Friend getFriendByNumber( int number ){
		for(Friend i : friends) {
			if (i.getNumber() == number)
				return i;
		}
		return null;
	}

}
