package com.example.weiyongqiang.stickeydemo.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.weiyongqiang.stickeydemo.R;
import com.example.weiyongqiang.stickeydemo.bean.TestEntity;

import java.util.List;

import androidx.appcompat.widget.AppCompatTextView;

public class TestAdapter extends BaseMultiItemQuickAdapter<TestEntity, BaseViewHolder>
{

	/**
	 * Same as QuickAdapter#QuickAdapter(Context,int) but with some initialization data.
	 *
	 * @param data
	 *            A new list is created out of this one to avoid mutable list
	 */
	public TestAdapter(List<TestEntity> data)
	{
		super(data);
		addItemType(TestEntity.HEAD_TYPE, R.layout.item_head);
		addItemType(TestEntity.ITEM_TYPE, R.layout.item_son);

	}

	@Override
	protected void convert(BaseViewHolder helper, TestEntity item)
	{
		switch (item.getItemType())
		{
		case TestEntity.HEAD_TYPE:

			AppCompatTextView showHeadTitle = helper.getView(R.id.headShowTitle);
			showHeadTitle.setText(item.getHeadName() + "");
			break;
		case TestEntity.ITEM_TYPE:
			AppCompatTextView sonName = helper.getView(R.id.sonName);
			sonName.setText(item.getItemName() + "");
			break;
		}

	}
}
