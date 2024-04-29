package com.example.onlineshop;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<ModelClass> productList;
    public Adapter(List<ModelClass> productList){
        this.productList=productList;
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int resource=productList.get(position).getImage();
        String prod=productList.get(position).getProduct();
        String cash=productList.get(position).getAmount();
        String desc=productList.get(position).getDescription();

        holder.setData(resource,prod,cash);
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),SingleProductActivity.class);
                intent.putExtra("image",resource);
                intent.putExtra("name",prod);
                intent.putExtra("amount",cash);
                intent.putExtra("description",desc);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView product;
        private TextView amount;
        private CardView cardview;

        private TextView description;
        public ViewHolder(View view) {
            super(view);
            image=itemView.findViewById(R.id.image);
            product=itemView.findViewById(R.id.product);
            amount=itemView.findViewById(R.id.amount);
            cardview=itemView.findViewById(R.id.cardview);
        }

        public void setData(int resource, String prod, String cash) {
            image.setImageResource(resource);
            product.setText(prod);
            amount.setText(cash);
        }
    }
}
