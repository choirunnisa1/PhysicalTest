package com.choirunnisa.physicaltest.AdapterApps;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.choirunnisa.physicaltest.ModelApps.OverhandModel;
import com.choirunnisa.physicaltest.R;

import java.util.List;

public class OverhandAdapter extends RecyclerView.Adapter {

    private List OverhandAdapterlist;

    public OverhandAdapter(List OverhandAdapterlist) {
        this.OverhandAdapterlist = OverhandAdapterlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.table_tree, parent, false);

        return new OverhandAdapter.RowViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        OverhandAdapter.RowViewHolder rowViewHolder = (OverhandAdapter.RowViewHolder) holder;

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

            OverhandModel OverhandModel = (OverhandModel) OverhandAdapterlist.get(rowPos - 1);
            rowViewHolder.txtRank.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtMovieName.setBackgroundResource(R.drawable.table_content_cell_bg);
            rowViewHolder.txtYear.setBackgroundResource(R.drawable.table_content_cell_bg);
           
            rowViewHolder.txtRank.setText(OverhandModel.getNo() + "");
            rowViewHolder.txtMovieName.setText(OverhandModel.getSkore());
            rowViewHolder.txtYear.setText(OverhandModel.getKategori() + "");
          
        }
    }

    @Override
    public int getItemCount() {
        return OverhandAdapterlist.size() + 1;
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
