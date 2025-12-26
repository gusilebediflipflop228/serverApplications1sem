package org.example.serveremulator.repository;

import org.example.serveremulator.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;


public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findByLessonId(Long lessonId);
    @Modifying
    void deleteByLessonId(Long lessonId);
    boolean existsByLessonId(Long lessonId);
}