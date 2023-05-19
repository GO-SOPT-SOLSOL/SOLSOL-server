package com.sopt.solsol.repository;

import com.sopt.solsol.domain.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {
    // Create


    // Read

    List<Ad> findAll();

    //Update

    // Delete
}
