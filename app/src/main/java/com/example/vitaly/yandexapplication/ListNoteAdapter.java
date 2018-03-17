package com.example.vitaly.yandexapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Vitaly on 17.03.2018.
 */

public class ListNoteAdapter extends BaseAdapter {

    private List<ListNote> notes;
    private LayoutInflater layoutInflater;

    public ListNoteAdapter(Context context, List<ListNote> notes) {
        this.notes = notes;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int i) {
        return notes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
