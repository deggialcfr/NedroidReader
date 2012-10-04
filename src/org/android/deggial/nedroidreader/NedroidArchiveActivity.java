package org.android.deggial.nedroidreader;


import net.bytten.comicviewer.ArchiveActivity;
import net.bytten.comicviewer.IComicDefinition;

public class NedroidArchiveActivity extends ArchiveActivity {

    @Override
    protected IComicDefinition makeComicDef() {
        return new NedroidComicDefinition();
    }

    @Override
    protected String getStringArchive() {
        //return null;
    	return getResources().getString(R.string.app_archive_label);
    }

    @Override
    protected String getStringBookmarks() {
        return getResources().getString(R.string.app_bookmarks_label);
    }

    @Override
    protected String getStringSearchByTitle() {
    	return "Search by Title";
    }

}
