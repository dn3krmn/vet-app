package com.dk.vetapp.service;


import com.dk.vetapp.dto.OwnerDto;

import java.util.List;

public interface OwnerService {

    List<OwnerDto> findAllOwner();

    void addOwner(OwnerDto ownerDto);

    OwnerDto findOwnerById(int ownerId);

    void updateOwner(OwnerDto ownerDto);

    void deleteOwner(int ownerId);
}
