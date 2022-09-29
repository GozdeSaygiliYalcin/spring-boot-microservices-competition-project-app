package com.gozdesy.service;

import com.gozdesy.repository.IWinnerRepository;
import com.gozdesy.repository.entity.Winner;
import com.gozdesy.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class WinnerService extends ServiceManager<Winner, Long> {

    private final IWinnerRepository winnerRepository;

    public WinnerService(IWinnerRepository winnerRepository) {
        super(winnerRepository);
        this.winnerRepository = winnerRepository;
    }
}
