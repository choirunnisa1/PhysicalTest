package com.choirunnisa.physicaltest.AdapterApps;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.choirunnisa.physicaltest.ModelApps.StandingModel;
import com.choirunnisa.physicaltest.R;

import java.util.List;

public class StandingAdapter extends RecyclerView.Adapter {

    private List Standinglist;

    public StandingAdapter(List Standinglist) {
        this.Standinglist = Standinglist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.table_list_item, parent, false);

        return new StandingAdapter.RowViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StandingAdapter.RowViewHolder rowViewHolder = (StandingAdapter.RowViewHolder) holder;

        int rowPos = rowViewHolder.getAdapterPosition();

        if (rowPos == 0) {

            rowViewHolder.txtRank.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtMovieName.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtYear.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtCost.setBackgroundResource(R.drawable.table_header_cell_bg);

            rowViewHolder.txtRank.setTextColor(Color.parseColor("#FFFFFF"));
            rowViewHolder.txtYear.setTextColor(Color.parseColor("#FFFFFF"));
            rowViewHolder.txtCost.setTextColor(Color.parseColor("#FFFFFF"));
            rowViewHolder.txtMovieName.setTextColor(Color.parseColor("#FFFFFF"));

            rowViewHolder.txtRank.setText("No");
            rowViewHolder.txtMovieName.setText("Skor Putra (cm)");
            rowViewHolder.txtYear.setText("Skor Putri (cm)");
            rowViewHolder.txtCost.setText("Kriteria");
        } else {

            StandingModel StandingModel = (StandingModel) Standinglist.get(rowPos - 1);
            rowViewHolder.txtRank.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtMovieName.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtYear.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtCost.setBackgroundResource(R.drawable.table_content_cell_bg);

            rowViewHolder.txtRank.setText(StandingModel.getNo() + "");
            rowViewHolder.txtMovieName.setText(StandingModel.getSkorePria());
            rowViewHolder.txtYear.setText(StandingModel.getSkoreWanita() + "");
            rowViewHolder.txtCost.setText(StandingModel.getKategori() + "");
        }
    }

    @Override
    public int getItemCount() {
        return Standinglist.size() + 1;
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        TextView txtRank;
        TextView txtMovieName;
        TextView txtYear;
        TextView txtCost;

        RowViewHolder(View itemView) {
            super(itemView);
            txtRank = itemView.findViewById(R.id.txtRank);
            txtMovieName = itemView.findViewById(R.id.txtMovieName);
            txtYear = itemView.findViewById(R.id.txtYear);
            txtCost = itemView.findViewById(R.id.txtCost);
        }
    }
}
