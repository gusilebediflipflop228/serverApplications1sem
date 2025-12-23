package org.example.serveremulator.repository;

import org.example.serveremulator.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByTeacherIdAndDateBetween(Long teacherId, LocalDate startDate, LocalDate endDate);

    List<Lesson> findByGroupIdAndDateBetween(Long groupId, LocalDate startDate, LocalDate endDate);

    boolean existsByGroupIdAndDateAndLessonNumber(Long groupId, LocalDate date, Integer lessonNumber);

    @Modifying
    void deleteByTeacherId(Long teacherId);

    @Modifying
    void deleteByGroupId(Long groupId);
}