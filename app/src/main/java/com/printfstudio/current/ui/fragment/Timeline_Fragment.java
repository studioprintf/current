package com.printfstudio.current.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.printfstudio.current.R;

/**
 * Created by DTLuc on 2015/7/17.
 */
public class Timeline_Fragment extends Fragment {
    private View fragmentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.timeline_recyclerview, container, false);

        return fragmentView;
    }
}
