package org.example.serveremulator.mapper;

import org.example.serveremulator.DTO.student.StudentRequest;
import org.example.serveremulator.DTO.student.StudentResponse;
import org.example.serveremulator.entity.Group;
import org.example.serveremulator.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequest request) {
        Student student = new Student();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setMiddleName(request.getMiddleName());
        student.setStatus(request.getStatus());

        if (request.getGroup() != null) {
            Group group = new Group();
            group.setId(request.getGroup().getId());
            student.setGroup(group);
        }

        return student;
    }

    public StudentResponse toResponse(Student student) {
        StudentResponse response = new StudentResponse();

        response.setId(student.getId());

        String fullName = student.getLastName() + " " + student.getFirstName();
        if (student.getMiddleName() != null && !student.getMiddleName().isEmpty()) {
            fullName += " " + student.getMiddleName();
        }
        response.setFullName(fullName);

        response.setGroupName(student.getGroup().getName());
        response.setStatus(student.getStatus().name());

        return response;
    }
}