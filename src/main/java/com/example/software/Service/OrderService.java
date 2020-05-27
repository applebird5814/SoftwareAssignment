package com.example.software.Service;

import com.example.software.Entity.DiaryOrder;

import java.util.List;

public interface OrderService {

    boolean createOrder(DiaryOrder diaryOrder);

    boolean changeOrderState(int id,String state);

    List<DiaryOrder> getAllOrder();
}
