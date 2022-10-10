package com.event.service;

import com.event.model.Setting;
import com.event.repository.SettingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingService {
    SettingRepository settingRepository;

    public Optional<Setting> find(Long id){
        return settingRepository.findById(id);
    }
}
