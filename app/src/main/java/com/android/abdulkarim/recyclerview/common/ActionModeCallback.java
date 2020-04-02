package com.android.abdulkarim.recyclerview.common;

import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.view.ActionMode;

public class ActionModeCallback implements ActionMode.Callback{
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}
