package com.choirunnisa.physicaltest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.choirunnisa.physicaltest.Database.DataHelper;
import com.choirunnisa.physicaltest.Hasil.DetailDataActivity;
import com.choirunnisa.physicaltest.Hasil.LihatDataActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.choirunnisa.physicaltest.R.*;

public class Adapter extends RecyclerView.Adapter<Adapter.HolderInput>{

    private Context context;
    private ArrayList<Model> modelArrayList;

    DataHelper dataHelper;

    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;

        dataHelper = new DataHelper(context);
    }

    @NonNull
    @Override
    public HolderInput onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(layout.content,parent,false);

        return new HolderInput(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderInput holder, final int position) {
        Model model = modelArrayList.get(position);
        final String id = model.getId();
        final String nama = model.getNama();
        final String jenis = model.getJenis();
        final String jkel = model.getJkel();
        final String usia  = model.getUsia();
        final String input = model.getInput();
        final String hasil  = model.getHasil();
        final String waktu = model.getWaktu();

        holder.namaTv.setText(nama);
        holder.jenisTv.setText(jenis);
        holder.inputTv.setText(input);
        holder.hasilTv.setText(hasil);




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailDataActivity.class);
                intent.putExtra("RECORD_ID", id);
                context.startActivity(intent);
            }
        });

        holder.Btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoreDialog(
                        ""+position,
                        ""+id,
                        ""+nama,
                        ""+jenis,
                        ""+jkel,
                        ""+usia,
                        ""+input,
                        ""+hasil,
                        ""+waktu
                );
            }
        });
    }

    private void showMoreDialog(String position, final String id,
                                final String nama, final String jenis,
                                final String jkel, final String usia,final String input,
                                final String hasil, final String waktu) {
        String[] options = {"Detail","Delete"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==0){
                    Intent intent = new Intent(context,DetailDataActivity.class);
                    intent.putExtra("RECORD_ID", id);
                    context.startActivity(intent);
                } else if (which==1){
                    dataHelper.deleteData(id);

                    ((LihatDataActivity)context).onResume();
                }
            }
        });
        builder.create().show();

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    class HolderInput extends RecyclerView.ViewHolder{


        TextView namaTv, jenisTv, inputTv, hasilTv;
        ImageButton Btn_more;

        public HolderInput(@NonNull View itemView) {
            super(itemView);

            namaTv = itemView.findViewById(id.namaTv);
            jenisTv = itemView.findViewById(id.jenisTv);
            inputTv = itemView.findViewById(id.inputTv);
            hasilTv = itemView.findViewById(id.hasilTv);
            Btn_more = itemView.findViewById(id.moreBtn);

        }
    }
}
