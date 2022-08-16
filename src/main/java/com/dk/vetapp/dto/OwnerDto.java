package com.dk.vetapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDto {

    private int ownerId;
    @NotEmpty(message = "Boş bırakılamaz")
    private String ownerName;
    @NotEmpty(message = "Boş bırakılamaz")
    private String ownerSurname;
    private String address;
    @NotEmpty(message = "Boş bırakılamaz")
    private String phoneNumber;
    @NotEmpty(message = "Boş bırakılamaz")
    private String email;
}
