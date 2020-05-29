package com.example.software;

import com.example.software.Dao.AdminDao;
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

    @Autowired
    private AdminDao adminDao;

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
    public void CCheckExist(){
        Assert.assertSame("exist",true, adminDao.findById("testtttt").isPresent());
    }

    @Test
    public void DChangePassword(){
        Admin admin = adminDao.findById("testtttt").get();
        admin.setPassword("passwordkkkkk");
        adminService.deleteAdminById("testtttt");
        adminService.createAdmin(admin);
        Assert.assertSame("change success","passwordkkkkk", adminDao.findById("testtttt").get().getPassword());
    }

    @Test
    public void EDeleteAdminSuccess(){
        Assert.assertSame("delete success",true,adminService.deleteAdminById("testtttt"));
    }

    @Test
    public void FDeleteAddressFail(){
        Assert.assertSame("delete success",false,adminService.deleteAdminById("testtttt"));
    }


}
