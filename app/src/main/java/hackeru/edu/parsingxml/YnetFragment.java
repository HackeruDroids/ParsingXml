package hackeru.edu.parsingxml;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class YnetFragment extends Fragment implements YnetDataSource.OnYnetArrivedListener {
    RecyclerView rvYnet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_ynet, container, false);
        rvYnet = (RecyclerView) v.findViewById(R.id.rvYnet);

        YnetDataSource.getYnet(this);

        return v;
    }

    @Override
    public void onYnetArrived(List<YnetDataSource.Ynet> data) {
        Toast.makeText(getActivity(), data.toString(), Toast.LENGTH_SHORT).show();
    }




    static class YnetAdapter extends RecyclerView.Adapter<YnetAdapter.YnetViewHolder>{
        //properties:
        List<YnetDataSource.Ynet> data;
        LayoutInflater inflater;
        Context context;
        //Constructor:
        public YnetAdapter(Context context, List<YnetDataSource.Ynet> data) {
            this.data = data;
            this.context = context;
            this.inflater = LayoutInflater.from(context); //Got the inflater from the Context.
        }
        @Override
        public YnetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = inflater.inflate(R.layout.ynet_item, parent, false);
            return new YnetViewHolder(v);
        }
        @Override
        public void onBindViewHolder(YnetViewHolder holder, int position) {
            YnetDataSource.Ynet ynet = data.get(position);
            holder.tvTitle.setText(ynet.getTitle());
            holder.tvDescription.setText(ynet.getContent());
            //TODO: Get the images from the thumbnailUrl
        }
        @Override
        public int getItemCount() {
            return data.size();
        }

        class YnetViewHolder extends RecyclerView.ViewHolder{
            TextView tvTitle;
            TextView tvDescription;
            ImageView ivThumbnail;
            public YnetViewHolder(View itemView) {
                super(itemView);
                tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
                tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
                ivThumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);
            }
        }
    }
}
