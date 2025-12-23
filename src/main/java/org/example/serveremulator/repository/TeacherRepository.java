package org.example.serveremulator.repository;


import org.example.serveremulator.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    boolean existsByLastNameAndFirstNameAndMiddleName(String lastName, String firstName, String middleName);
}
