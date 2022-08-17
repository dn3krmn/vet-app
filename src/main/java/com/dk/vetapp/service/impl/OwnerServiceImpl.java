package com.dk.vetapp.service.impl;

import com.dk.vetapp.dto.OwnerDto;
import com.dk.vetapp.entity.Owner;
import com.dk.vetapp.mapper.OwnerMapper;
import com.dk.vetapp.repository.OwnerRepository;
import com.dk.vetapp.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<OwnerDto> findAllOwner() {
        List<Owner> owners = ownerRepository.findAll();
        return owners.stream().map(OwnerMapper::mapToOwnerDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addOwner(OwnerDto ownerDto) {
        Owner owner = OwnerMapper.mapToOwner(ownerDto);
        ownerRepository.save(owner);
    }

    @Override
    public OwnerDto findOwnerById(int ownerId) {
        Owner owner = ownerRepository.findById(ownerId).get();
        return OwnerMapper.mapToOwnerDto(owner);
    }

    @Override
    public void updateOwner(OwnerDto ownerDto) {
        Owner owner = OwnerMapper.mapToOwner(ownerDto);
        ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(int ownerId) {
        ownerRepository.deleteById(ownerId);
    }

    @Override
    public List<OwnerDto> searchOwners(String query) {
        List<Owner> owners = ownerRepository.searchOwners(query);
        return owners.stream().map(OwnerMapper::mapToOwnerDto)
                .collect(Collectors.toList());
    }
}
