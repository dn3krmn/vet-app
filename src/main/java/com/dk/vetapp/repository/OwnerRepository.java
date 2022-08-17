package com.dk.vetapp.repository;

import com.dk.vetapp.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    Optional<Owner> findByOwnerName(String ownerName);

    @Query("SELECT owner from Owner owner WHERE owner.ownerName LIKE CONCAT('%', :query, '%') OR " +
            "owner.ownerSurname LIKE CONCAT('%', :query, '%')")
    List<Owner> searchOwners(String query);
}
