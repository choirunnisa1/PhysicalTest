package com.choirunnisa.physicaltest.AdapterApps;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.choirunnisa.physicaltest.ModelApps.SquartModel;
import com.choirunnisa.physicaltest.R;

import java.util.List;

public class SquartAdapter extends RecyclerView.Adapter {

    private List SquartAdapterlist;

    public SquartAdapter(List SquartAdapterlist) {
        this.SquartAdapterlist = SquartAdapterlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.table_tree, parent, false);

        return new SquartAdapter.RowViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SquartAdapter.RowViewHolder rowViewHolder = (SquartAdapter.RowViewHolder) holder;

        int rowPos = rowViewHolder.getAdapterPosition();

        if (rowPos == 0) {

            rowViewHolder.txtRank.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtMovieName.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtYear.setBackgroundResource(R.drawable.table_header_cell_bg);


            rowViewHolder.txtRank.setTextColor(Color.parseColor("#FFFFFF"));
            rowViewHolder.txtMovieName.setTextColor(Color.parseColor("#FFFFFF"));
            rowViewHolder.txtYear.setTextColor(Color.parseColor("#FFFFFF"));


            rowViewHolder.txtRank.setText("No");
            rowViewHolder.txtMovieName.setText("Skor");
            rowViewHolder.txtYear.setText("Kategori");

        } else {

            SquartModel SquartModel = (SquartModel) SquartAdapterlist.get(rowPos - 1);
            rowViewHolder.txtRank.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtMovieName.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtYear.setBackgroundResource(R.drawable.table_content_cell_bg);

            rowViewHolder.txtRank.setText(SquartModel.getNo() + "");
            rowViewHolder.txtMovieName.setText(SquartModel.getAngka());
            rowViewHolder.txtYear.setText(SquartModel.getKategori() + "");

        }
    }

    @Override
    public int getItemCount() {
        return SquartAdapterlist.size() + 1;
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        TextView txtRank;
        TextView txtMovieName;
        TextView txtYear;


        RowViewHolder(View itemView) {
            super(itemView);
            txtRank = itemView.findViewById(R.id.txtRank);
            txtMovieName = itemView.findViewById(R.id.txtMovieName);
            txtYear = itemView.findViewById(R.id.txtYear);

        }
    }
}
