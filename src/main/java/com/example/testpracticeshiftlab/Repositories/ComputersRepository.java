package com.example.testpracticeshiftlab.Repositories;

import com.example.testpracticeshiftlab.Entities.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputersRepository extends JpaRepository<Computer, Long> {
}
