/*
 * 
 *  xkcdViewer and ComicViewer
 *  Copyright (C) 2009-2012 Tom Coxon, Tyler Breisacher, David McCullough,
 *      Kristian Lundkvist.
 *  
 *  Bunsen is Copyright (C) SrPinto.
 *  
 *  Gunshow is Copyright (C) KC Green.
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package org.android.deggial.nedroidreader;


import net.bytten.comicviewer.ArchiveActivity;
import net.bytten.comicviewer.ComicViewerActivity;
import net.bytten.comicviewer.IComicDefinition;

public class NedroidViewerActivity extends ComicViewerActivity {

    @Override
    protected IComicDefinition makeComicDef() {
        return new NedroidComicDefinition();
    }

    @Override
    protected Class<? extends ArchiveActivity> getArchiveActivityClass() {
        return NedroidArchiveActivity.class;
    }

    @Override
    protected String getStringAboutText() {
        return getResources().getString(R.string.aboutText);
    }

    @Override
    protected String getStringAppName() {
        return getResources().getString(R.string.app_name);
    }

}
