package com.cyj.finaltest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cyj.finaltest.R;
import com.cyj.finaltest.datas.Company;

import java.util.List;

public class CompanyAdapter extends ArrayAdapter<Company> {

    Context mContext;
    List<Company> mList;
    LayoutInflater inf;

    public CompanyAdapter (Context context, List<Company> list){
//        super문 작성시. list 빼먹으면 안된다. list의 내용을 가져오지 못한다.
        super(context, R.layout.delivery_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null){
            row = inf.inflate(R.layout.delivery_list_item, null);
        }

        ImageView logoImgView = row.findViewById(R.id.logoImgView);
        TextView deliveryNameTxt = row.findViewById(R.id.deliveryNameTxt);
        TextView deliveryIdTxt = row.findViewById(R.id.deliveryIdTxt);

        Company data = mList.get(position);

        Glide.with(mContext).load(data.getLogo()).into(logoImgView);

        deliveryNameTxt.setText(data.getName());

//        setText에 int를 집어넣으면 안된다. -> String.valueOf 를 사용
        deliveryIdTxt.setText(String.valueOf(data.getId()));

        return row;
    }
}
