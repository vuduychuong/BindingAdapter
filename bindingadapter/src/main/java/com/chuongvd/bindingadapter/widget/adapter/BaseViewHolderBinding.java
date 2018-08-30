package com.chuongvd.bindingadapter.widget.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class BaseViewHolderBinding<BINDINGVIEW extends ViewDataBinding, MODEL>
        extends RecyclerView.ViewHolder {

    public BINDINGVIEW mBinding;
    public BaseAdapterBinding.OnRecyclerItemListener<MODEL> mListener;
    private MODEL data;

    public BaseViewHolderBinding(BINDINGVIEW binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public BaseViewHolderBinding(BINDINGVIEW binding,
            BaseAdapterBinding.OnRecyclerItemListener<MODEL> listener) {
        super(binding.getRoot());
        mBinding = binding;
        mListener = listener;
    }

    public void bindData(MODEL model) {
        data = model;
        mBinding.getRoot().setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onItemClick(getAdapterPosition(), data);
            }
        });
    }
}
