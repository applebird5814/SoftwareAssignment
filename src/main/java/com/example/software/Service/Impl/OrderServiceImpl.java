package com.example.software.Service.Impl;

import com.example.software.Dao.OrderDao;
import com.example.software.Entity.DiaryOrder;
import com.example.software.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public boolean createOrder(DiaryOrder diaryOrder) {
        if(orderDao.findById(diaryOrder.getId()).isPresent()) {
            return false;
        }
        orderDao.saveAndFlush(diaryOrder);
        return true;
    }

    @Override
    public boolean changeOrderState(int id,String state) {
        if(orderDao.findById(id).isPresent()) {
            orderDao.updateStatus(id,state);
            return true;
        }
        return false;
    }

    @Override
    public List<DiaryOrder> getAllOrder() {
        return orderDao.findAll();
    }

    @Override
    public List<DiaryOrder> getAllByUserId(String userId) {
        return orderDao.findByUserId(userId);
    }

}
