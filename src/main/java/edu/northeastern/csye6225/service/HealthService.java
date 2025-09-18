package edu.northeastern.csye6225.service;

import edu.northeastern.csye6225.model.HealthCheck;
import edu.northeastern.csye6225.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HealthService {

    @Autowired
    private HealthRepository repository;

    @Transactional
    public void insertCheck() {
        repository.save(new HealthCheck());
    }
}
