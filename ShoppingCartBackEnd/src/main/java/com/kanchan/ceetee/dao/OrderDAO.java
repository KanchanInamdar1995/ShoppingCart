package com.kanchan.ceetee.dao;

import com.kanchan.ceetee.domain.OrderDetail;

public interface OrderDAO
{
	public boolean receiptGenerate(OrderDetail orderDetail);
	public boolean updateCartItemStatus(String emailID);
}
