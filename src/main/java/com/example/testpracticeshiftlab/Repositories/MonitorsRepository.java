package com.example.testpracticeshiftlab.Repositories;

import com.example.testpracticeshiftlab.Entities.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorsRepository extends JpaRepository<Monitor, Long> {
}
