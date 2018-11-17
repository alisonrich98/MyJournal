package com.example.office1.myjournal;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class SpinnerAdapter extends BaseAdapter {

    int[] colors = new int[]{Color.BLACK, Color.BLUE};

    LayoutInflater inflater;
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        ViewHolder holder;
        Context context = viewGroup.getContext();
        if(view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.spinner_row, viewGroup, false);
            holder = new ViewHolder();
            holder.image = itemView.findViewById(R.id.spinner2);
            itemView.setTag(holder);
        } else {
            holder = (ViewHolder) itemView.getTag();
        }

        holder.image.setImageDrawable(context.getResources().getDrawable(colors[i]));
        return itemView;
    }
}
