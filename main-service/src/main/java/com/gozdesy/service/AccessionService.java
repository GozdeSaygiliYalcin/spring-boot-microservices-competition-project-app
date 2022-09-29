package com.gozdesy.service;

import com.gozdesy.repository.IAccesionRepository;
import com.gozdesy.repository.entity.Accession;
import com.gozdesy.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AccessionService extends ServiceManager<Accession, Long> {

    private final IAccesionRepository accesionRepository;

    public AccessionService(IAccesionRepository accesionRepository) {
        super(accesionRepository);
        this.accesionRepository = accesionRepository;
    }
}
