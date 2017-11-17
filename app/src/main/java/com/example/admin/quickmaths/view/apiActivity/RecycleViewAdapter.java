package com.example.admin.quickmaths.view.apiActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.quickmaths.DetailActivity;
import com.example.admin.quickmaths.R;
import com.example.admin.quickmaths.model.display.DisplayObject;
import com.example.admin.quickmaths.view.detailsActivity.DetailsActivity;
import com.example.admin.quickmaths.view.mainActivity.MainActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private static final String TAG = "RecycleViewAdapter";
    public List<DisplayObject> itemList = new ArrayList<>();
    private Context context;
    private DecimalFormat df = new DecimalFormat("#.00");
    private Activity activity;
//    private RecyclerViewItemClickListener listener;

    public RecycleViewAdapter(Context context, List<DisplayObject> itemList, Activity activity) {
        this.context = context;
        this.itemList = itemList;
//        this.listener = (RecyclerViewItemClickListener) context;
        this.activity = activity;
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
        switch( item.getStore() ) {
            case "Wal-Mart":
            case "Wal-Mart.com":
                url = "http://1000logos.net/wp-content/uploads/2017/05/New-Walmart-logo.jpg";
                break;
            case "Newegg Business":
            case "Newegg Canada":
            case "Newegg.com":
                url = "https://images10.newegg.com/WebResource/Themes/2005/Nest/logo_424x210.png";
                break;
            case "Sam's Club":
                url = "http://vignette2.wikia.nocookie.net/logopedia/images/0/05/Sams-Club-" +
                        "Logo-300x300.jpg/revision/latest?cb=20110326063427";
                break;
            case "Target":
                url = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Target_logo" +
                        ".svg/2000px-Target_logo.svg.png";
                break;
            case "JCPenney":
                url = "https://www.underconsideration.com/brandnew/archives/jcpenney_2013_logo" +
                        "_detail.png";
                break;
            case "Dell.com":
                url = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Dell_Logo" +
                        ".svg/600px-Dell_Logo.svg.png";
                break;
            case "Fye.com":
                url = "https://vignette.wikia.nocookie.net/logopedia/images/4/48/F.y.e..svg" +
                        "/revision/latest/scale-to-width-down/200?cb=20170104134023";
                break;
            case "Best Buy":
                url = "http://freelogophoto.b-cdn.net/wp-content/uploads/2012/04/best_buy-logo.jpg";
                break;
            case "Amazon" :
                url = "http://freelogo2016cdn.b-cdn.net/wp-content/uploads/2016/12/amazon_logo.png";
                break;
        }

        Glide.with(context)
                .load( url )
                .into(holder.storeLogo);

        holder.productName.setText( item.getProduct() );
        holder.storeName.setText(  item.getStore() );
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
        TextView productName, priceDollars, priceCents, storeName;
        DisplayObject d;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Log.d(TAG, "onClick: clicked");
//                    Intent intent = new Intent(context, PlacesActivity.class);
//                    intent.putExtra("deal", d);
//                    context.startActivity(intent);
                    FragmentManager fragmentManager = activity.getFragmentManager();

                    Bundle args = new Bundle();
//                    args.putString("query",rawResult.getText());
                    args.putParcelable("displayObject", d);
                    DetailActivity frag = new DetailActivity();
                    frag.setArguments(args);
                    ((MainActivity) activity).setCurrentFrag(frag);
                    Log.d(TAG, "onClick: " + activity.getLocalClassName());
                    fragmentManager.beginTransaction()
                            .replace(R.id.content_frame, frag)
                            .addToBackStack("detail_activity")
                            .commit();
                    Log.d(TAG, "onClick: clicked");
                }
            });

            storeLogo = itemView.findViewById( R.id.ivLogo );
            productName = itemView.findViewById( R.id.tvProductName);
            priceDollars = itemView.findViewById( R.id.tvPriceDollars );
            priceCents = itemView.findViewById( R.id.tvPrinceCents );
            storeName = itemView.findViewById( R.id.tvStoreName );
        }

//        @Override
//        public void onClick(View view) {
//            Log.d(TAG, "onClick: ");
//        }
    }

    public Activity getactivity(){
        return this.activity;
    }
//    interface RecyclerViewItemClickListener {
//        void onItemClicked(DisplayObject displayObject);
//    }
}
