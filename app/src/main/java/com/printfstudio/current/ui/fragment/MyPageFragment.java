package com.printfstudio.current.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.printfstudio.current.R;
import com.printfstudio.current.ui.activity.MainActivity;

public class MyPageFragment extends Fragment {
    private View fragmentView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_mypage, container, false);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.setToolbar((Toolbar) fragmentView.findViewById(R.id.toolbar));
        return fragmentView;
    }
}
