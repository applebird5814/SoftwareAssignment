package com.example.software.Service.Impl;
import com.example.software.Dao.AddressDao;
import com.example.software.Entity.Address;
import com.example.software.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public boolean createAddress(Address address) {
        if(addressDao.findByUserId(address.getUserId()).isPresent()){
            return false;
        }
        addressDao.saveAndFlush(address);
        return true;
    }

//    @Override
//    public List<Address> getAddress(String userId) {
//        return addressDao.findByUserId(userId);
//    }

    @Override
    public boolean deleteAddress(Address address) {
        if(addressDao.findByUserId(address.getUserId()).isPresent()){
            System.out.println(address.getUserId());
            addressDao.deleteByUserId(address.getUserId());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAddress(Address address) {
        if(addressDao.findByUserId(address.getUserId()).isPresent()){
            System.out.println(address.getUserId());
            addressDao.updateByUserId(address.getId(), address.getAddress(), address.getPostCode(), address.getState(), address.getUrban(), address.getUserId());
            return true;
        }
        return false;
    }


}
