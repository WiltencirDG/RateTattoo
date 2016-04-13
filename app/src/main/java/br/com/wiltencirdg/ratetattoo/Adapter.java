package br.com.wiltencirdg.ratetattoo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.ratetattoo.R;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
        implements View.OnClickListener{

    private List<GetStudios> mData;
    private View.OnClickListener listener;

    public Adapter(List<GetStudios> myData) {
        mData = myData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivImage;
        public TextView tvName;
        public TextView tvAddress;

        public ViewHolder(View v) {
            super(v);
            ivImage = (ImageView)v.findViewById(R.id.img_shop);
            tvName = (TextView)v.findViewById(R.id.name_shop);
            tvAddress = (TextView)v.findViewById(R.id.ad_shop);
        }
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.placer, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ivImage.setImageResource(mData.get(position).getIdImage());
        holder.tvName.setText(mData.get(position).getName());
        holder.tvAddress.setText(mData.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }


}
