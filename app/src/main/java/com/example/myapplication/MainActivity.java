package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.myapplication.models.Example;
import com.example.myapplication.network.ApiService;
import com.example.myapplication.network.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView coupounRv;
    ApiService apiService;
    List<Example> mainExmapleList = new ArrayList<>();
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        coupounRv = findViewById(R.id.coupounsRv);


        getData();
        progressDialog = CommonUtils.showLoadingDialog(MainActivity.this);
    }

    private void getData()
    {
        apiService = ApiUtils.getAPIService();
        apiService.getCoupounsdata("4c663239-03af-49b5-bcb3-0b0c41565bd2").enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                if (response.isSuccessful())
                {
                    if (response.code()==200)
                    {
                        mainExmapleList = response.body();
                        Log.d("SIZE", String.valueOf(mainExmapleList.size()));
                        if (mainExmapleList!=null && mainExmapleList.size()>0)
                        {
                            ItemAdapter itemAdapter = new ItemAdapter(mainExmapleList,MainActivity.this);
                            coupounRv.setHasFixedSize(true);
                            coupounRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            coupounRv.setAdapter(itemAdapter);
                        }

                    }
                }else{
                    if (response.code() == 402) {
                        Toast.makeText(MainActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                    } else if (response.code() == 504) {
                        Toast.makeText(MainActivity.this,"Time Out",Toast.LENGTH_SHORT).show();
                    } else if (response.code() == 500) {
                        Toast.makeText(MainActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                    } else if (response.code() == 502) {
                        Toast.makeText(MainActivity.this,"Server Not Responding",Toast.LENGTH_SHORT).show();
                    } else if (response.code() == 401) {
                    } else if (response.code() == 422) {
                        Toast.makeText(MainActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                Log.d("ResponseEXCEp",t.toString());
            }
        });

    }
}