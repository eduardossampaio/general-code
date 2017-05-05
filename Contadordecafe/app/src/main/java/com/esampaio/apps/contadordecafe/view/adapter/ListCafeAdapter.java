package com.esampaio.apps.contadordecafe.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.esampaio.apps.contadordecafe.R;

/**
 * Created by eduardo on 20/03/17.
 */

public class ListCafeAdapter extends RecyclerView.Adapter<ListCafeAdapter.ListCafeAdapterVH> {
    private Integer qtdCafes = 0;
    private Context context=null;

    private static final int QTD_MAX_CAFE = 18;
    public ListCafeAdapter(Context context) {
        this.context = context;
    }

    public static class ListCafeAdapterVH extends RecyclerView.ViewHolder{
        private View maisX;
        private TextView textMaisX;
        private ImageView viewCafe;
        public ListCafeAdapterVH(View itemView) {
            super(itemView);
            viewCafe = (ImageView) itemView.findViewById(R.id.imageView);
            maisX = itemView.findViewById(R.id.mais_layout);
            textMaisX = (TextView) itemView.findViewById(R.id.txt_mais_x);
        }
    }

    @Override
    public ListCafeAdapterVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(context).inflate(R.layout.list_cafe_item,null,false);
        return new ListCafeAdapterVH(layout);
    }

    @Override
    public void onBindViewHolder(ListCafeAdapterVH holder, int position) {
        if(position<QTD_MAX_CAFE-1){
            holder.maisX.setVisibility(View.GONE);
            holder.viewCafe.setVisibility(View.VISIBLE);
        }else{
            holder.maisX.setVisibility(View.VISIBLE);
            holder.viewCafe.setVisibility(View.GONE);
            int excedente = qtdCafes - QTD_MAX_CAFE;
            if(excedente==0){
                holder.textMaisX.setVisibility(View.INVISIBLE);
            }else {
                holder.textMaisX.setText("+" + excedente);
            }
        }
    }

    @Override
    public int getItemCount() {
        return qtdCafes<QTD_MAX_CAFE ? qtdCafes : QTD_MAX_CAFE;
    }

    public void setQtdCafes(Integer qtdCafes) {
        this.qtdCafes = qtdCafes;
        notifyDataSetChanged();
    }
}
