package com.event.repository;

import com.event.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Enterprise, Long> {
}
