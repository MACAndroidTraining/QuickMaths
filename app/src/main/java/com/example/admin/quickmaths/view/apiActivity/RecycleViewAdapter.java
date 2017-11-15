package com.example.admin.quickmaths.view.apiActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.quickmaths.MapsActivity;
import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.model.display.DisplayObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private static final String TAG = "RecycleViewAdapter";
    private List<DisplayObject> itemList = new ArrayList<>();
    private Context context;
    private DecimalFormat df = new DecimalFormat("#.00");
    private RecyclerViewItemClickListener listener;

    public RecycleViewAdapter(Context context, List<DisplayObject> itemList) {
        this.context = context;
        this.itemList = itemList;
//        this.listener = (RecyclerViewItemClickListener) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upc_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DisplayObject item = itemList.get(position);

        String url = "";
        if( item.getLogoURL() != null ) {
            url = item.getLogoURL();
        } else {
            switch( item.getStore() ) {
                case "Wal-Mart.com":
                    url = "http://1000logos.net/wp-content/uploads/2017/05/New-Walmart-logo.jpg";
                    break;
                case "Newegg Business" :
                case "Newegg Canada" :
                case "Newegg.com" :
                    url = "https://images10.newegg.com/WebResource/Themes/2005/Nest/logo_424x210.png";
                    break;
                case "Sam's Club" :
                    url = "http://vignette2.wikia.nocookie.net/logopedia/images/0/05/Sams-Club-" +
                            "Logo-300x300.jpg/revision/latest?cb=20110326063427";
                    break;
                case "Target" :
                    url = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Target_logo" +
                            ".svg/2000px-Target_logo.svg.png";
                    break;
                case "JCPenney" :
                    url = "https://www.underconsideration.com/brandnew/archives/jcpenney_2013_logo" +
                            "_detail.png";
                    break;
                case "Dell.com" :
                    url = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Dell_Logo" +
                            ".svg/600px-Dell_Logo.svg.png";
                    break;
                case "Fye.com" :
                    url = "https://vignette.wikia.nocookie.net/logopedia/images/4/48/F.y.e..svg" +
                            "/revision/latest/scale-to-width-down/200?cb=20170104134023";
                    break;
                case "Best Buy" :
                    url = "http://freelogophoto.b-cdn.net/wp-content/uploads/2012/04/best_buy-logo.jpg";
                    break;
                default:
                    holder.storeName.setText( item.getStore() );
                    holder.storeLogo.setVisibility(View.GONE);
            }
        }

        Glide.with(context)
                .load( url )
                .into(holder.storeLogo);

        holder.productName.setText( item.getProduct() );

        String distance = (item.isOnLine()) ? "Online" : item.getDistance() + " miles.";
        holder.storeDistance.setText( distance );

        String price = String.valueOf( df.format( item.getPrice() ));
        String dollars = price.substring(0, price.indexOf('.'));
        String cents = price.substring(price.indexOf('.') + 1);
        holder.priceDollars.setText( dollars );
        holder.priceCents.setText( cents );
        holder.d = item;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView storeLogo;
        TextView productName, storeDistance, priceDollars, priceCents, storeName;
        DisplayObject d;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: clicked");
                    Intent intent = new Intent(context, MapsActivity.class);
                    intent.putExtra("store", d.getStore());
                    context.startActivity(intent);
                }
            });

            storeLogo = itemView.findViewById( R.id.ivLogo );
            productName = itemView.findViewById( R.id.tvProductName);
            storeDistance = itemView.findViewById( R.id.tvStoreDistance );
            priceDollars = itemView.findViewById( R.id.tvPriceDollars );
            priceCents = itemView.findViewById( R.id.tvPrinceCents );
            storeName = itemView.findViewById( R.id.tvStoreName );
        }

//        @Override
//        public void onClick(View view) {
//            Log.d(TAG, "onClick: ");
//        }
    }

    interface RecyclerViewItemClickListener {
        void onItemClicked(DisplayObject displayObject);
    }
}
