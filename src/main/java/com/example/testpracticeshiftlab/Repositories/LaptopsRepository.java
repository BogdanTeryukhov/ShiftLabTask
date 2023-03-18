package com.example.testpracticeshiftlab.Repositories;

import com.example.testpracticeshiftlab.Entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopsRepository extends JpaRepository<Laptop, Long> {
}
