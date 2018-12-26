package com.example.weiyongqiang.stickeydemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class TestEntity implements MultiItemEntity
{
	private String		type;			// 0 表示头部，1表示子布局
	private String		headName;
	private String		itemName;
	private int			itemType;

	public static final int	HEAD_TYPE	= 1;
	public static final int	ITEM_TYPE	= 2;

	public void setItemType(int itemType)
	{
		this.itemType = itemType;
	}

	public TestEntity(String type, String headName, String itemName)
	{
		this.type = type;
		this.headName = headName;
		this.itemName = itemName;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getHeadName()
	{
		return headName;
	}

	public void setHeadName(String headName)
	{
		this.headName = headName;
	}

	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	@Override
	public int getItemType()
	{
		return itemType;
	}
}
