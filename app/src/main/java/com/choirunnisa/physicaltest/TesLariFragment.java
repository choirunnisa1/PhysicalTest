package com.choirunnisa.physicaltest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.choirunnisa.physicaltest.AdapterApps.LariAdapter;
import com.choirunnisa.physicaltest.Kecepatan.TestLariActivity;
import com.choirunnisa.physicaltest.ModelApps.LariModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TesLariFragment extends Fragment {
    Button buttonSave;
    RadioButton rb_laki, rb_perempuan;
    String str;
    String hasil;

    public TesLariFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tes_lari, container, false);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        buttonSave = getActivity().findViewById(R.id.proses);
        rb_laki = getActivity().findViewById(R.id.laki);
        rb_perempuan = getActivity().findViewById(R.id.perempuan);


        RecyclerView recyclerView = getActivity().findViewById(R.id.recyclerViewDeliveryProductList);

        LariAdapter adapter = new LariAdapter(getLariList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        RecyclerView recyclerView2 = getActivity().findViewById(R.id.recyclerViewDeliveryProductList2);
        LariAdapter adapter2 = new LariAdapter(getLariList2());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(adapter2);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editNama = (EditText) getActivity().findViewById(R.id.nama);
                String opName = editNama.getText().toString();
                EditText editJenis = (EditText) getActivity().findViewById(R.id.jenis);
                String opJenis = editJenis.getText().toString();
                EditText editinput = (EditText) getActivity().findViewById(R.id.input);
                String opInput = editinput.getText().toString();
                RadioGroup rb_fitness = getActivity().findViewById(R.id.jk);
                EditText editUsia = getActivity().findViewById(R.id.usia);
                String opUsia = editUsia.getText().toString();


                if (opName.equals("") || opInput.length() == 0 || rb_fitness.getCheckedRadioButtonId() == -1 || opUsia.equals("")) {
                    Toast.makeText(getActivity(), "Mohon Lengkapi Terlebih Dahulu",
                            Toast.LENGTH_SHORT).show();
                } else {


                    double input = Double.parseDouble(opInput);


                    if (rb_laki.isChecked()) {
                        str = "Laki-laki";
                        if (input > 5.12) {
                            hasil = "Kurang Sekali";
                        } else if (input >= 4.73 && input <= 5.11) {
                            hasil = "Kurang";
                        } else if (input >= 4.35 && input <= 4.72) {
                            hasil = "Sedang";
                        } else if (input >= 3.92 && input <= 4.34) {
                            hasil = "Baik";
                        } else if (input >= 3.58 && input <= 3.91) {
                            hasil = "Sangat Baik";
                        }
                    } else if (rb_perempuan.isChecked()) {
                        str = "Perempuan";
                        if (input >=5.86) {
                            hasil = "Kurang Sekali";
                        } else if (input >= 5.41 && input <= 5.86) {
                            hasil = "Kurang";
                        } else if (input >= 4.97 && input <= 5.40) {
                            hasil = "Sedang";
                        } else if (input >= 4.51 && input <= 4.96) {
                            hasil = "Baik";
                        } else if (input >= 4.06 && input <= 4.50) {
                            hasil = "Sangat Baik";
                        }
                    } else {
                        Toast.makeText(getActivity(), "Mohon Lengkapi Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                    }



                    Intent intent = new Intent(getActivity(), HasilActivity.class);

                    intent.putExtra("nama", opName);
                    intent.putExtra("jenis", opJenis);
                    intent.putExtra("input", opInput);
                    intent.putExtra("hasil", hasil);
                    intent.putExtra("usia",opUsia);
                    intent.putExtra("jenis_kelamin", str);
                    startActivity(intent);
                }
            }
        });


    }
    private List getLariList() {
        List lariList = new ArrayList<>();

        lariList.add(new LariModel(1, "5.12-5.50", "Kurang Sekali"));
        lariList.add(new LariModel(2, "4.73-5.11", "Kurang"));
        lariList.add(new LariModel(3, "4.35-4.72", "Sedang"));
        lariList.add(new LariModel(4, "3.92-4.34", "Baik"));
        lariList.add(new LariModel(5, "3.58-3.91", "Baik Sekali"));

        return lariList;
    }

    private List getLariList2() {
        List lariList = new ArrayList<>();

        lariList.add(new LariModel(1, "5.86-6.30", "Kurang Sekali"));
        lariList.add(new LariModel(2, "5.86-5.41", "Kurang"));
        lariList.add(new LariModel(3, "4.97-5.40", "Sedang"));
        lariList.add(new LariModel(5, "4.51-4.96", "Baik"));
        lariList.add(new LariModel(6, "4.06-4.50", "Baik Sekali"));
        return lariList;


    }
}
