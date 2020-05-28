package com.example.software;

import com.example.software.Entity.Address;
import com.example.software.Service.AddressService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressServiceTest extends SoftwareApplicationTests {

    @Autowired
    @Qualifier("AddressServiceImpl")
    AddressService addressService;

    @Test
    public void ACreateAddress(){
        Address address = new Address();
        address.setId("test");
        address.setAddress("test address");
        address.setUserId("test user id");
        address.setPostCode("3000");
        address.setState("vic");
        address.setUrban("mel");
        Assert.assertSame("create success",true,addressService.createAddress(address));
    }

    @Test
    public void BCreateAddressFail(){
        Address address = new Address();
        address.setId("test");
        address.setAddress("test address");
        address.setUserId("test user id");
        address.setPostCode("3000");
        address.setState("vic");
        address.setUrban("mel");
        Assert.assertSame("create fail",false,addressService.createAddress(address));
    }

    @Test
    public void CDeleteAddressSuccess(){
        Assert.assertSame("delete success",true,addressService.deleteAddress("test"));
    }

    @Test
    public void DDeleteAddressFail(){
        Assert.assertSame("delete error address",false,addressService.deleteAddress("0"));
    }
}
