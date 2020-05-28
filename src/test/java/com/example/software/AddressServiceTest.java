package com.example.software;

import com.example.software.Entity.Address;
import com.example.software.Service.AddressService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AddressServiceTest extends SoftwareApplicationTests {

    @Autowired
    @Qualifier("AddressServiceImpl")
    AddressService addressService;

    @Test
    public void testDeleteAddressFail(){
        Assert.assertSame("delete error address",false,addressService.deleteAddress("0"));
    }

    @Test
    public void testCreateAddress(){
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
    public void testDeleteAddressSuccess(){
        Assert.assertSame("delete success",true,addressService.deleteAddress("test"));
    }
}
