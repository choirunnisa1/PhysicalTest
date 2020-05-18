package com.choirunnisa.physicaltest.AdapterApps;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.choirunnisa.physicaltest.ModelApps.AgiltyModel;
import com.choirunnisa.physicaltest.ModelApps.FitnesModel;
import com.choirunnisa.physicaltest.ModelApps.FitnesModel;
import com.choirunnisa.physicaltest.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FitnessAdapter extends RecyclerView.Adapter {

    private List fitneslist;

    public FitnessAdapter(List fitneslist) {
        this.fitneslist = fitneslist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.table_content, parent, false);

        return new FitnessAdapter.RowViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FitnessAdapter.RowViewHolder rowViewHolder = (FitnessAdapter.RowViewHolder) holder;

        int rowPos = rowViewHolder.getAdapterPosition();

        if (rowPos == 0) {
            rowViewHolder.txtRank.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtMovieName.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtYear.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtCost.setBackgroundResource(R.drawable.table_header_cell_bg);
            rowViewHolder.txtKat.setBackgroundResource(R.drawable.table_header_cell_bg);


            rowViewHolder.txtRank.setTextColor(Color.parseColor("#FFFFFF"));
            rowViewHolder.txtYear.setTextColor(Color.parseColor("#FFFFFF"));
            rowViewHolder.txtCost.setTextColor(Color.parseColor("#FFFFFF"));
            rowViewHolder.txtMovieName.setTextColor(Color.parseColor("#FFFFFF"));
            rowViewHolder.txtKat.setTextColor(Color.parseColor("#FFFFFF"));

            rowViewHolder.txtRank.setText("Kategori");
            rowViewHolder.txtMovieName.setText("<30 Tahun>");
            rowViewHolder.txtYear.setText("30-39 Tahun");
            rowViewHolder.txtCost.setText("40-49 Tahun");
            rowViewHolder.txtKat.setText(">50 Tahun");
            
        } else {

            FitnesModel fitnesModel = (FitnesModel) fitneslist.get(rowPos - 1);
            
            rowViewHolder.txtRank.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtMovieName.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtYear.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtCost.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtKat.setBackgroundResource(R.drawable.table_content_cell_bg);

            rowViewHolder.txtRank.setText(fitnesModel.getKat() + "");
            rowViewHolder.txtMovieName.setText(fitnesModel.getUsiaA()+"");
            rowViewHolder.txtYear.setText(fitnesModel.getUsiaB() + "");
            rowViewHolder.txtCost.setText(fitnesModel.getUsiaC() + "");
            rowViewHolder.txtKat.setText(fitnesModel.getUsiaD() + "");

        }
    }

    @Override
    public int getItemCount() {
        return fitneslist.size() + 1;
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        TextView txtRank;
        TextView txtMovieName;
        TextView txtYear;
        TextView txtCost;
        TextView txtKat;

        RowViewHolder(View itemView) {
            super(itemView);
            txtRank = itemView.findViewById(R.id.txtRank);
            txtMovieName = itemView.findViewById(R.id.txtMovieName);
            txtYear = itemView.findViewById(R.id.txtYear);
            txtCost = itemView.findViewById(R.id.txtCost);
            txtKat = itemView.findViewById(R.id.txtKat);
        }
    }
}
