package org.android.deggial.nedroidreader;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.bytten.comicviewer.IComicInfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.net.Uri;
import android.util.Log;

public class NedroidComicInfo implements IComicInfo {

	public Uri img, url;
	public String num="";
	public String title = "", alt = "";
	public boolean bookmarked;

	public String getAlt() {
		return alt;
	}

	public String getId() {
		return num;
	}

	public Uri getImage() {
		return img;
	}

	public String getNextId() {
		String y= "2005",m = "09",id = "2210-whee";
		String theString = "";

		try {
			Document doc = Jsoup.connect(url.toString()).timeout(30 * 1000).get();
			try{
				theString = doc.getElementById("menunav").child(1).toString();
			}
			catch(Exception e){
				e.printStackTrace();
				Log.d("nextid1 catch", e.toString());
				theString = "";
			}
			Log.d("input", theString);
			final Pattern pattern = Pattern.compile("\"http://nedroid.com/(.+?)/(.+?)/(.+?)/\"");
			final Matcher matcher = pattern.matcher(theString);

			if(matcher.find()&&!"".contains(theString)){
				y = matcher.group(1);
				m = matcher.group(2);
				id = matcher.group(3);
			}
			else{
				y="404";
				m = "";
				id = "";
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Log.d("nextid2 catch", e1.toString());
		}

		return y+"/"+m+"/"+id;
	}

	public String getPrevId() {
		String y= "2005",m = "09",id = "2210-whee";
		String theString = "";
		try {
			Document doc = Jsoup.connect(url.toString()).timeout(30 * 1000).get();
			try{
				theString = doc.getElementById("menunav").child(0).toString();
			}
			catch(Exception e){
				e.printStackTrace();
				Log.d("nextid1 catch", e.toString());
				theString = "";
			}
			final Pattern pattern = Pattern.compile("\"http://nedroid.com/(.+?)/(.+?)/(.+?)/\"");
			final Matcher matcher = pattern.matcher(theString);

			if(matcher.find() && !doc.getElementById("menunav").child(0).attr("rel").toString().contains("next")){
				y = matcher.group(1);
				m = matcher.group(2);
				id = matcher.group(3);
			}
			else{
				y="404";
				m = "";
				id = "";
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Log.d("previd catch", e1.toString());
		}

		return y+"/"+m+"/"+id;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return "http://nedroid.com/"+getId()+"/";
	}

	public boolean isBookmarked() {
		return bookmarked;
	}

	public void setBookmarked(boolean b) {
		bookmarked = b;
	}

}
