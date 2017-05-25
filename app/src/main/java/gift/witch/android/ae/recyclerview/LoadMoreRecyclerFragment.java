package gift.witch.android.ae.recyclerview;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gift.witch.android.ae.R;

public class LoadMoreRecyclerFragment extends Fragment {

    private LoadMoreRecyclerView mRecyclerView;

    private BaseRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loadmorerecycler,null);
        mRecyclerView = (LoadMoreRecyclerView)view.findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new RecyclerViewDecoration(getContext(), RecyclerViewDecoration.VERTICAL_LIST));

        mAdapter = new BaseRecyclerAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnLoadMore(new LoadMoreRecyclerView.OnLoadMore() {
            @Override
            public void onLoad() {
                mHandler.sendEmptyMessageDelayed(0,3000);
            }
        });


        return view;
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mAdapter.add();
            if(mAdapter.getItemCount() > 50){
                mRecyclerView.setLoadMoreStatus(LoadMoreRecyclerView.STATUS_EMPTY);
            }else{
                mRecyclerView.setLoadMoreStatus(LoadMoreRecyclerView.STATUS_PREPARE);
            }
        }
    };

}
