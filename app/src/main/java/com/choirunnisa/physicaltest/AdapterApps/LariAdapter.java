package com.choirunnisa.physicaltest.AdapterApps;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.choirunnisa.physicaltest.ModelApps.LariModel;
import com.choirunnisa.physicaltest.ModelApps.LariModel;
import com.choirunnisa.physicaltest.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LariAdapter extends RecyclerView.Adapter {

    private List larilist;

    public LariAdapter(List larilist) {
        this.larilist = larilist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.table_lcontent, parent, false);

        return new LariAdapter.RowViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RowViewHolder rowViewHolder = (RowViewHolder) holder;

        int rowPos = rowViewHolder.getAdapterPosition();

        if (rowPos == 0) {

            rowViewHolder.txtRank.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtYear.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtCost.setBackgroundResource(R.drawable.table_header_cell_bg);

            rowViewHolder.txtRank.setTextColor(Color.parseColor("#FFFFFF"));
            rowViewHolder.txtYear.setTextColor(Color.parseColor("#FFFFFF"));
            rowViewHolder.txtCost.setTextColor(Color.parseColor("#FFFFFF"));

            rowViewHolder.txtRank.setText("No");
            rowViewHolder.txtYear.setText("Klasifikasi");
            rowViewHolder.txtCost.setText("Waktu(detik)");
        } else {

            LariModel lariModel = (LariModel) larilist.get(rowPos - 1);
            rowViewHolder.txtRank.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtYear.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtCost.setBackgroundResource(R.drawable.table_content_cell_bg);

            rowViewHolder.txtRank.setText(lariModel.getNo() + "");
            rowViewHolder.txtYear.setText(lariModel.getAngka()+ "");
            rowViewHolder.txtCost.setText(lariModel.getKategori() + "");

        }
    }

    @Override
    public int getItemCount() {
        return larilist.size() + 1;
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        TextView txtRank;
        TextView txtYear;
        TextView txtCost;

        RowViewHolder(View itemView) {
            super(itemView);
            txtRank = itemView.findViewById(R.id.txtRank);
            txtYear = itemView.findViewById(R.id.txtYear);
            txtCost = itemView.findViewById(R.id.txtCost);
        }
    }
}
