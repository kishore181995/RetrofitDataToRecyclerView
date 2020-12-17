package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.Example;
import com.example.myapplication.models.SlabsAdapter;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHOlder>
{
    List<Example> exampleList;
    Context mContext;
    Date date;

    public ItemAdapter(List<Example> mainExmapleList, MainActivity mainActivity) {
        this.exampleList = mainExmapleList;
        this.mContext = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_item_layout, parent, false);
        return new MyViewHOlder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHOlder holder, int position)
    {
        //code set text
        holder.code.setText(exampleList.get(position).getCode());
        //ribbon msg  set text
        holder.ribbon.setText(exampleList.get(position).getRibbonMsg());
        holder.wagerbonusexpirey.setText("Bonus expiry in "+exampleList.get(position).getWagerBonusExpiry()+" days from the issue");
        holder.waggerrealeaseratio.setText("For every  \u20B9"+exampleList.get(position).getWagerToReleaseRatioNumerator()+" bet , \u20B9"+exampleList.get(position).getWagerToReleaseRatioDenominator()+" will be released as bonus amount");
//        holder.percentage.setText("Get"+exampleList.get(position).getS);

        SlabsAdapter slabsAdapter = new SlabsAdapter(exampleList.get(position).getSlabs(),mContext);
        holder.mSlabs.setHasFixedSize(true);
        holder.mSlabs.setLayoutManager(new LinearLayoutManager(mContext));
        holder.mSlabs.setAdapter(slabsAdapter);
        String dateStr = exampleList.get(position).getValidUntil();
        String timeStr = dateStr.substring(11,16);
        dateStr= dateStr.substring(0,10);
        Log.d("DATE",dateStr);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            formatter.parse(dateStr);
            String p_date = dateStr;
            try {
                date = formatter.parse(p_date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            String monthString = new DateFormatSymbols().getMonths()[cal.get(Calendar.MONTH)];

            String strFirstThree = monthString.substring(0, 3) + " ," + cal.get(Calendar.YEAR);
            String formatedDate = cal.get(Calendar.DATE) + " " + strFirstThree;
            int val = 0;
            if (timeStr!=null && timeStr.length()>0)
            {
                val = Integer.parseInt(timeStr.substring(0,2));
                if (val>12)
                {
                    holder.validStr.setText("valid till "+formatedDate+" "+ timeStr+" PM");
                }else{
                    holder.validStr.setText("valid till "+formatedDate+" "+ timeStr+" AM");
                }
            }



        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Setting the max of the requred perctages of Wax and bonus
        Float maxWag=0f,maxotc=0f,sumWagOtc=0f,maxWagper=0f,maxOtcper=0f,sumWagOtcPer=0f;
        if (exampleList.get(position).getSlabs()!=null) {
            for (int i = 0; i < exampleList.get(position).getSlabs().size(); i++) {
                if (exampleList.get(position).getSlabs().get(i).getOtcMax() > maxotc) {
                    maxotc = exampleList.get(position).getSlabs().get(i).getOtcMax();
                }
            }
            for (int i = 0; i < exampleList.get(position).getSlabs().size(); i++) {
                if (exampleList.get(position).getSlabs().get(i).getWageredMax() > maxotc) {
                    maxWag = exampleList.get(position).getSlabs().get(i).getWageredMax();
                }
            }
            sumWagOtc = maxotc + maxWag;

            for (int i = 0; i < exampleList.get(position).getSlabs().size(); i++) {
                if (exampleList.get(position).getSlabs().get(i).getWageredPercent() > maxWagper) {
                    maxWagper = exampleList.get(position).getSlabs().get(i).getWageredPercent();
                }
            }
            for (int i = 0; i < exampleList.get(position).getSlabs().size(); i++) {
                if (exampleList.get(position).getSlabs().get(i).getOtcPercent() > maxOtcper) {
                    maxOtcper = exampleList.get(position).getSlabs().get(i).getOtcPercent();
                }
            }
            sumWagOtcPer = maxWagper+maxOtcper;
            holder.percentage.setText("Get "+Math.round(sumWagOtcPer)+"% upto \u20B9" + Math.round(sumWagOtc));

            Float minslab=10000f;
            for (int i = 0; i < exampleList.get(position).getSlabs().size(); i++) {
                if (exampleList.get(position).getSlabs().get(i).getMin() < minslab) {
                    minslab = exampleList.get(position).getSlabs().get(i).getMin();
                }
            }
            holder.minSlabs.setText("\u20B9"+minslab);


        }

        holder.hideDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (exampleList.get(position).isOpen())
                {
                    exampleList.get(position).setOpen(false);
                    holder.detauls.setVisibility(View.GONE);
                    holder.hideDetails.setText("Show Details");
                    holder.arrowIv.setBackgroundResource(R.drawable.down_arrow);
                }else if (!exampleList.get(position).isOpen()){
                    exampleList.get(position).setOpen(true);
                    holder.detauls.setVisibility(View.VISIBLE);
                    holder.arrowIv.setBackgroundResource(R.drawable.up_arrow);
                    holder.hideDetails.setText("Hide Details");
                }
                notifyDataSetChanged();
            }
        });

        if (exampleList.get(position).isOpen())
        {
            holder.detauls.setVisibility(View.VISIBLE);
            holder.arrowIv.setBackgroundResource(R.drawable.up_arrow);
        }else if (!exampleList.get(position).isOpen()){
            holder.detauls.setVisibility(View.GONE);
            holder.arrowIv.setBackgroundResource(R.drawable.down_arrow);
        }


    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    public class MyViewHOlder extends RecyclerView.ViewHolder {
        RecyclerView mSlabs;
        LinearLayout detauls;
        AppCompatImageView arrowIv;
        AppCompatTextView code,ribbon,percentage,wagerbonusexpirey,waggerrealeaseratio,validStr,minSlabs,hideDetails;
        public MyViewHOlder(@NonNull View itemView) {
            super(itemView);
            mSlabs = itemView.findViewById(R.id.slabsRv);
            code = itemView.findViewById(R.id.codeTv);
            ribbon = itemView.findViewById(R.id.ribbonTv);
            percentage = itemView.findViewById(R.id.getPercentTv);
            wagerbonusexpirey = itemView.findViewById(R.id.waggerBonusexpireyTv);
            waggerrealeaseratio = itemView.findViewById(R.id.waggerRelaseRatioTv);
            validStr = itemView.findViewById(R.id.validTillTv);
            minSlabs = itemView.findViewById(R.id.minSlabTv);
            hideDetails = itemView.findViewById(R.id.hideDetailsTv);
            detauls = itemView.findViewById(R.id.detailsLl);
            arrowIv = itemView.findViewById(R.id.arrowIv);
        }
    }
}
