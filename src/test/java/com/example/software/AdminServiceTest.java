package com.example.software;

import com.example.software.Entity.Admin;
import com.example.software.Service.AdminService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminServiceTest extends SoftwareApplicationTests{

    @Autowired
    @Qualifier("AdminServiceImpl")
    AdminService adminService;

    @Test
    public void ACreateAdmin(){
        Admin admin = new Admin();
        admin.setId("testtttt");
        admin.setUsername("testadmin");
        admin.setPassword("passwordddd");
        admin.setType("tester");

        Assert.assertSame("create success",true,adminService.createAdmin(admin));
    }

    @Test
    public void BCreateAdminFail(){
        Admin admin = new Admin();
        admin.setId("testtttt");
        admin.setUsername("testadmin");
        admin.setPassword("passwordddd");
        admin.setType("tester");

        Assert.assertSame("create fail",false,adminService.createAdmin(admin));
    }

    @Test
    public void CDeleteAdminSuccess(){
        Assert.assertSame("delete success",true,adminService.deleteAdminById("testtttt"));
    }

    @Test
    public void DDeleteAddressFail(){
        Assert.assertSame("delete success",false,adminService.deleteAdminById("testtttt"));
    }


}
