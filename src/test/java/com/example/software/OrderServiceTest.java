package com.example.software;

import com.example.software.Entity.DiaryOrder;
import com.example.software.Service.OrderService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderServiceTest extends SoftwareApplicationTests {

    @Autowired
    @Qualifier("orderServiceImpl")
    OrderService orderService;

    @Test
    public void ACreateOrder(){
        DiaryOrder diaryOrder = new DiaryOrder();
        diaryOrder.setId(1);
        diaryOrder.setUserId("userid testing");
        diaryOrder.setAddress("address testing");
        diaryOrder.setTime("time testing");
        diaryOrder.setDeliverOption("deliver option");
        diaryOrder.setState("state option");
        Assert.assertSame("create success",true,orderService.createOrder(diaryOrder));
    }

    @Test
    public void BCreateOrderFail(){
        DiaryOrder diaryOrder = new DiaryOrder();
        diaryOrder.setId(1);
        diaryOrder.setUserId("userid testing");
        diaryOrder.setAddress("address testing");
        diaryOrder.setTime("time testing");
        diaryOrder.setDeliverOption("deliver option");
        diaryOrder.setState("state option");
        Assert.assertSame("create fail",false,orderService.createOrder(diaryOrder));
    }

    @Test
    public void CChangeOrderState(){
        Assert.assertSame("change success",true,orderService.changeOrderState(1,"change state testing"));
    }

    @Test
    public void DChangeOrderStateFail(){
        Assert.assertSame("change fail",false,orderService.changeOrderState(0,"change state testing"));
    }

    @Test
    public void EGetAllOrder(){
        List<DiaryOrder> diaryOrders;
        diaryOrders = orderService.getAllOrder();
        Assert.assertSame("get all success",1,diaryOrders.size());
    }

    @Test
    public void FGetAllByUserId(){
        List<DiaryOrder> diaryOrders;
        diaryOrders = orderService.getAllByUserId("userid testing");
        Assert.assertSame("get all by user id success",1,diaryOrders.size());
    }
}
