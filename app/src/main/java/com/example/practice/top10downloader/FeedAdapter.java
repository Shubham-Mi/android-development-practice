package com.example.practice.top10downloader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.practice.R;

import java.util.List;

public class FeedAdapter extends ArrayAdapter {
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private final List<FeedEntry> applications;

    public FeedAdapter(Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.applications = applications;
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(layoutResource, parent, false);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvArtist = view.findViewById(R.id.tvArtist);
        TextView tvSummary = view.findViewById(R.id.tvSummary);
        FeedEntry  currentApp = applications.get(position);

        tvName.setText(currentApp.getName());
        tvArtist.setText(currentApp.getArtist());
        tvSummary.setText(currentApp.getSummary());

        return view;
    }

    @Override
    public int getCount() {
        return applications.size();
    }
}
