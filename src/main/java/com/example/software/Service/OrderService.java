package com.example.software.Service;

import com.example.software.Entity.DiaryOrder;

public interface OrderService {

    boolean createOrder(DiaryOrder diaryOrder);

    boolean changeOrderState(int id,String state);

    boolean addAddressAndDeliverOption(int id,String address,String deliverOption);
}
