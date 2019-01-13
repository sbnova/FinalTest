package com.cyj.finaltest;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.cyj.finaltest.adapter.CompanyAdapter;
import com.cyj.finaltest.datas.Company;
import com.cyj.finaltest.utils.ConnectServer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    List<Company> companyList = new ArrayList<Company>();
    CompanyAdapter mAdapter;

    private android.widget.ListView deliveryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        mAdapter = new CompanyAdapter(mContext, companyList);
        deliveryListView.setAdapter(mAdapter);

        getCompanyFromServer();

    }

    void getCompanyFromServer() {

        ConnectServer.getRequestCompanys(mContext, new ConnectServer.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                Log.d("회사목록",json.toString());

                try {
                    int code = json.getInt("code");

                    if(code == 200){
                        JSONObject data = json.getJSONObject("data");
                        JSONArray company = data.getJSONArray("company");

                        for(int i = 0; i<company.length();i++){
                            JSONObject companyJson = company.getJSONObject(i);

                            Company companyObject = Company.getCompanyFromJson(companyJson);

                            companyList.add(companyObject);
                        }

//                       사용시 error 발생시 runOnUiThread를 사용 그 안에다가 본 문장을 집어넣는다.
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                mAdapter.notifyDataSetChanged();
//                            }
//                        });

                        mAdapter.notifyDataSetChanged();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void bindViews() {
        this.deliveryListView = (ListView) findViewById(R.id.deliveryListView);
    }
}
