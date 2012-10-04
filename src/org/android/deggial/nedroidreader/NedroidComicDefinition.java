package org.android.deggial.nedroidreader;

import java.util.regex.Pattern;

import net.bytten.comicviewer.IComicDefinition;
import net.bytten.comicviewer.IComicProvider;
import android.net.Uri;

public class NedroidComicDefinition implements IComicDefinition {

	static public final Pattern
	nedroidHomePattern = Pattern.compile(
			"http://(www\\.)?nedroid\\.com(/)?"),
			comicUrlPattern = Pattern.compile(
					"http://(www\\.)?nedroid\\.com//([0-9]+)(/)?"),
					archiveUrlPattern = Pattern.compile(
							"http://(www\\.)?nedroid\\.com/archive.php(/)?");

	private NedroidComicProvider provider;

	public NedroidComicDefinition() {
		provider = new NedroidComicProvider(this);
	}

	public Uri getArchiveUrl() {
		return Uri.parse("http://nedroid.com/");
	}

	public String getAuthorLinkText() {
		return "Nedroid official website";
	}

	public Uri getAuthorLinkUrl() {
		return Uri.parse("http://nedroid.com");
	}

	public String getAuthorName() {
		return "Anthony Clark";
	}

	public String getComicTitle() {
		return "Nedroid";
	}

	public String getComicTitleAbbrev() {
		return "Nedroid";
	}

	public String getPackageName() {
		return "org.android.deggial.nedroidreader";
	}

	public boolean hasAltText() {
		return true;
	}

	public boolean idsAreNumbers() {
		return true;
	}

	public boolean isArchiveUrl(Uri url) {
		return archiveUrlPattern.matcher(url.toString()).matches();
	}

	public boolean isComicUrl(Uri url) {
		return comicUrlPattern.matcher(url.toString()).matches();
	}

	public boolean isHomeUrl(Uri url) {
		return nedroidHomePattern.matcher(url.toString()).matches();
	}

	public IComicProvider getProvider() {
		return provider;
	}

	public Uri getDonateUrl() {
		return Uri.parse("");
	}

	public Uri getDevDonateUrl() {
		return Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=ZR6D9T8MH8G62");
	}

	public Uri getAuthorDonateUrl() {
		return Uri.parse("http://www.topatoco.com/merchant.mvc?Screen=CTGY&Store_Code=TO&Category_Code=NED");");
	}

}
