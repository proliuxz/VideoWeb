package org.videolan.vlc.gui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.videolan.vlc.R;
import org.videolan.vlc.Util;
import org.videolan.vlc.VLCApplication;
import org.videolan.vlc.gui.audio.AudioBrowserFragment;

import org.videolan.vlc.gui.video.VideoGridFragment;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SidebarAdapter extends BaseAdapter {
    public final static String TAG = "VLC/SidebarAdapter";

    static class SidebarEntry {
        String id;
        String name;
        int drawableID;

        public SidebarEntry(String _id, String _name, int _drawableID) {
            this.id = _id;
            this.name = _name;
            this.drawableID = _drawableID;
        }

        public SidebarEntry(String _id, int _name, int _drawableID) {
            this.id = _id;
            this.name = VLCApplication.getAppContext().getString(_name);
            this.drawableID = _drawableID;
        }
    }

    private LayoutInflater mInflater;
    static final List<SidebarEntry> entries;
    private HashMap<String, Fragment> mFragments;

    static {
        SidebarEntry entries2[] = {
         	 new SidebarEntry( "video", R.string.video, R.drawable.header_icon_video ),  //视频菜单项
             //new SidebarEntry( "audio", R.string.audio, R.drawable.header_icon_audio ),//音频菜单项
             new SidebarEntry( "directories", R.string.directories, R.drawable.ic_folder ),//菜单项
            new SidebarEntry( "history", R.string.history, android.R.drawable.ic_menu_recent_history ),
            //new SidebarEntry( "bookmarks", R.string.bookmarks, R.drawable.ic_bookmarks ),
            //new SidebarEntry( "playlists", R.string.playlists, R.drawable.icon ),
            //new SidebarEntry( "netclass", R.string.netclass, android.R.drawable.ic_menu_recent_history ),
            new SidebarEntry( "netclass2", R.string.netclass, android.R.drawable.ic_menu_search),
            new SidebarEntry( "callme", R.string.phonecall, android.R.drawable.ic_menu_call ),
        };
        entries = Arrays.asList(entries2);
    }

    public SidebarAdapter() {
        mInflater = LayoutInflater.from(VLCApplication.getAppContext());
        mFragments = new HashMap<String, Fragment>(entries.size());
    }

    @Override
    public int getCount() {
        return entries.size();
    }

    @Override
    public Object getItem(int position) {
        return entries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long)position; // The SidebarEntry list is unique
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        SidebarEntry sidebarEntry = entries.get(position);

        /* If view not created */
        if(v == null) {
            v = mInflater.inflate(R.layout.sidebar_item, parent, false);
        }
        TextView textView = (TextView)v;
        textView.setText(sidebarEntry.name);
        Drawable img = VLCApplication.getAppResources().getDrawable(sidebarEntry.drawableID);
        if (img != null) {
            int dp_32 = Util.convertDpToPx(32);
            img.setBounds(0, 0, dp_32, dp_32);
            textView.setCompoundDrawables(img, null, null, null);
        }

        return v;
    }

    public Fragment fetchFragment(String id) {
        if(mFragments.containsKey(id) && mFragments.get(id) != null) {
            return mFragments.get(id);
        }
        Fragment f;
        if(id.equals("audio")) {
            f = new AudioBrowserFragment();
        } else if(id.equals("video")) {
            f = new VideoGridFragment();
        } else if(id.endsWith("directories")) {
            f = new DirectoryViewFragment();
        } else if(id.equals("history")) {
            f = new HistoryFragment();
        }
        else if(id.equals("netclass")) {
            f = new NetClassFragment();
        } 
        else if(id.equals("netclass2")) {
            f = new NetClass2Fragment();
        } else if(id.equals("callme")) {
            f = new CallMeFragment();
        }  else { /* TODO */
            f = new AboutLicenceFragment();
        }
        f.setRetainInstance(true);
        mFragments.put(id, f);
        return f;
    }

    /**
     * When Android has automatically recreated a fragment from the bundle state,
     * use this function to 'restore' the recreated fragment into this sidebar
     * adapter to prevent it from trying to create the same fragment again.
     *
     * @param id ID of the fragment
     * @param f The fragment itself
     */
    public void restoreFragment(String id, Fragment f) {
        if(f == null) {
            Log.e(TAG, "Can't set null fragment for " + id + "!");
            return;
        }
        mFragments.put(id, f);
        // if Android added it, it's been implicitly added already...
    }
}
