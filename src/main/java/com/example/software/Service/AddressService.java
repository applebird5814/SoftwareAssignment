package com.example.software.Service;

import com.example.software.Entity.Address;

import java.util.List;

public interface AddressService {

    boolean createAddress(Address address);

    boolean deleteAddress(String id);

    List<Address> findByUserId(String userId);
}
