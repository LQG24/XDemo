package com.example.demox.view.local;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by chan on 2016/5/18.
 */
public class LocalImageFragment  extends Fragment{

    public static LocalImageFragment newInstance() {
        
        Bundle args = new Bundle();
        
        LocalImageFragment fragment = new LocalImageFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
