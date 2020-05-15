package com.example.software.Service;

import com.example.software.Entity.Address;

import java.util.List;

public interface AddressService {

    boolean createAddress(Address address);
//    List<Address> getAddress(String userId);
    boolean deleteAddress(Address address);
    boolean updateAddress(Address address);
}
