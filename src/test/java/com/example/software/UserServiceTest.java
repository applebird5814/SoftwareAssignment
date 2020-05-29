package com.example.software;

import com.example.software.Service.AdminService;
import com.example.software.Entity.User;
import com.example.software.Service.Impl.AdminServiceImpl;
import com.example.software.Service.UserService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest extends SoftwareApplicationTests {

    @Autowired
    @Qualifier("userServiceImpl")
    UserService userService;

    @Autowired
    @Qualifier("AdminServiceImpl")
    AdminService adminService;

    @Test
    public void ACreateUser(){
        User user = new User();
        user.setId("testID");
        user.setPassword("testPW");
        user.setMailAddress("testAdd@test.com");
        user.setUsername("testName");
        user.setScreenName("testSName");
        user.setTelephone("13000000000");
        Assert.assertSame("create success",true,userService.createUser(user));
    }

    @Test
    public void BCreateAddressFail(){
        User user = new User();
        user.setId("testID");
        user.setPassword("testPW");
        user.setMailAddress("testAdd@test.com");
        user.setUsername("testName");
        user.setScreenName("testSName");
        user.setTelephone("13000000000");
        Assert.assertSame("create fail",false,userService.createUser(user));
    }

    @Test
    public void CDeleteUserSuccess(){
        Assert.assertSame("delete success",true,adminService.deleteUserById("testID"));
    }

    @Test
    public void DDeleteUserFail(){
        Assert.assertSame("delete error address",false,adminService.deleteUserById("wrongTestID"));
    }
}
