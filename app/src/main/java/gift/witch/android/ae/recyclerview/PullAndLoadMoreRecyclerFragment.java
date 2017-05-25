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

public class PullAndLoadMoreRecyclerFragment extends Fragment {

    private PullAndLoadMoreRefreshRecyclerView mRecyclerView;
    private SimplePullAndLoadMoreRecyclerAdapter mBaseRecyclerAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pullandloadmorerecycler,null);


        mRecyclerView = (PullAndLoadMoreRefreshRecyclerView) view.findViewById(R.id.recycler);
        mBaseRecyclerAdapter = new SimplePullAndLoadMoreRecyclerAdapter(container.getContext());

        mRecyclerView.setAdapter(mBaseRecyclerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new RecyclerViewDecoration(getContext(), RecyclerViewDecoration.VERTICAL_LIST));
        mRecyclerView.setOnRefreshAndLoadMoreListener(new PullAndLoadMoreRefreshRecyclerView.OnRefreshAndLoadMoreListener() {
            @Override
            public void onRefresh() {
                mHandler.sendEmptyMessageDelayed(0,3000);

            }

            @Override
            public void onLoadMore() {
                mLoadMoreHandler.sendEmptyMessageDelayed(0,3000);

            }
        });

        return view;
    }



    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            mRecyclerView.completeRefresh();
        }
    };

    Handler mLoadMoreHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mBaseRecyclerAdapter.add();
            mRecyclerView.completeLoadMore();
            mRecyclerView.noMoreData();
        }
    };

}
