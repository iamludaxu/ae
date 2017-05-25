package gift.witch.android.ae.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import gift.witch.android.ae.R;

public class SimplePullAndLoadMoreRecyclerAdapter extends PullAndLoadMoreRecyclerViewAdapter {


    private Context mContext;



    public SimplePullAndLoadMoreRecyclerAdapter(Context context) {
        mContext = context;
        setData(new ArrayList());
        init();

    }

    public void init() {
        for (int i = 0; i < 20; i++) {
            DemoData demoData1 = new DemoData();
            demoData1.setDemoTitleData("setDemoTitleData" + i);
            data.add(demoData1);
        }

    }


    public void add() {
        for (int i = 0; i < 20; i++) {
            DemoData demoData1 = new DemoData();
            demoData1.setDemoTitleData("ADD setDemoTitleData" + i);
            data.add(demoData1);
        }
        notifyDataSetChanged();
    }


    @Override
    protected RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext
        ).inflate(R.layout.adapter_item_baserecycler, parent,
                false);//这个布局就是一个imageview用来显示图片
        RecyclerViewHolder holder = new RecyclerViewHolder(view);

        return holder;
    }

    @Override
    protected void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        DemoData demoData = (DemoData)data.get(position);
        RecyclerViewHolder temp = (RecyclerViewHolder) holder;
        temp.setTitle(demoData.getDemoTitleData());
        temp.setImageView(demoData.getDemoImageData());
    }



    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTitle;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mTitle = (TextView) itemView.findViewById(R.id.title);
        }

        public void setTitle(String title) {
            mTitle.setText(title);
        }

        public void setImageView(String url) {

        }
    }


    public static class DemoData {


        private String demoTitleData;
        private String demoImageData;

        public String getDemoTitleData() {
            return demoTitleData;
        }

        public void setDemoTitleData(String demoTitleData) {
            this.demoTitleData = demoTitleData;
        }

        public String getDemoImageData() {
            return demoImageData;
        }

        public void setDemoImageData(String demoImageData) {
            this.demoImageData = demoImageData;
        }
    }
}
