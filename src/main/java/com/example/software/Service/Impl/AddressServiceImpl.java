package com.example.software.Service.Impl;

import com.example.software.Dao.AddressDao;
import com.example.software.Entity.Address;
import com.example.software.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Transactional
    @Override
    public boolean createAddress(Address address) {
        if (addressDao.findById(address.getId()).isPresent()) {
            return false;
        }
        addressDao.saveAndFlush(address);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteAddress(String id) {
        if (addressDao.findById(id).isPresent()) {
            addressDao.deleteAddressById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Address> findByUserId(String userId) {
        return addressDao.findByUserId(userId);
    }


}
