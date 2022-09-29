package com.gozdesy.service;

import com.gozdesy.repository.IScanningRepository;
import com.gozdesy.repository.entity.Scanning;
import com.gozdesy.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ScanningService extends ServiceManager<Scanning, Long> {

    private final IScanningRepository scanningRepository;

    public ScanningService(IScanningRepository scanningRepository) {
        super(scanningRepository);
        this.scanningRepository = scanningRepository;
    }
}
