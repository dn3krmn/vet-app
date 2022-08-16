package com.dk.vetapp.mapper;

import com.dk.vetapp.dto.OwnerDto;
import com.dk.vetapp.entity.Owner;

public class OwnerMapper {

    //map Owner entity to OwnerDto
    public static OwnerDto mapToOwnerDto(Owner owner){
        OwnerDto ownerDto = OwnerDto.builder()
                .ownerId(owner.getOwnerId())
                .ownerName(owner.getOwnerName())
                .ownerSurname(owner.getOwnerSurname())
                .phoneNumber(owner.getPhoneNumber())
                .address(owner.getAddress())
                .email(owner.getEmail())
                .build();

        return ownerDto;
    }
    //map OwnerDto to Owner entity
    public static Owner mapToOwner(OwnerDto ownerDto){
        Owner owner = Owner.builder()
                .ownerId(ownerDto.getOwnerId())
                .ownerName(ownerDto.getOwnerName())
                .ownerSurname(ownerDto.getOwnerSurname())
                .phoneNumber(ownerDto.getPhoneNumber())
                .address(ownerDto.getAddress())
                .email(ownerDto.getEmail())
                .build();

        return owner;
    }
}
