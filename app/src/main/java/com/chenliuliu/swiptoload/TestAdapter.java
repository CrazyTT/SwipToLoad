package com.chenliuliu.swiptoload;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by liuliuchen on 16/1/15.
 */
public class TestAdapter extends ArrayListAdapter<String> {
    public TestAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_test, parent, false);
            vh = new ViewHolder();
            vh.name = (TextView) convertView.findViewById(R.id.text_test);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.name.setText(mList.get(position));
        return convertView;
    }

    class ViewHolder {
        TextView name;
    }
}
