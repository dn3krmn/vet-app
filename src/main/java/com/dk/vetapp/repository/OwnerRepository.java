package com.dk.vetapp.repository;

import com.dk.vetapp.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    Optional<Owner> findByOwnerName(String ownerName);
}
