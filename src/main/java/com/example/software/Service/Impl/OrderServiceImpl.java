package com.example.software.Service.Impl;

import com.example.software.Dao.OrderDao;
import com.example.software.Entity.DiaryOrder;
import com.example.software.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional
    @Override
    public boolean createOrder(DiaryOrder diaryOrder) {
        if (orderDao.findById(diaryOrder.getId()).isPresent()) {
            return false;
        }
        orderDao.saveAndFlush(diaryOrder);
        return true;
    }

    @Transactional
    @Override
    public boolean changeOrderState(int id, String state) {
        if (orderDao.findById(id).isPresent()) {
            orderDao.updateStatus(id, state);
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

    @Override
    public boolean deleteById(int id) {
        if (orderDao.findById(id).isPresent()) {
            orderDao.deleteById(id);
            return true;
        }
        return false;
    }


}
