package com.example.testpracticeshiftlab.Repositories;

import com.example.testpracticeshiftlab.Entities.HDD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HDDRepository extends JpaRepository<HDD, Long> {
}
