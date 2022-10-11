package com.event.service;

import com.event.model.Enterprise;
import com.event.repository.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnterpriseService {
    EnterpriseRepository enterpriseRepository;

    public Optional<Enterprise> find(Long id){
        return enterpriseRepository.findById(id);
    }
}
