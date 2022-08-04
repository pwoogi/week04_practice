package com.sparta.week04_practice.repository;

import com.sparta.week04_practice.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
