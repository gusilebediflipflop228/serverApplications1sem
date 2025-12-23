package org.example.serveremulator.mapper;

import org.example.serveremulator.DTO.TeacherRequest;
import org.example.serveremulator.DTO.TeacherResponse;
import org.example.serveremulator.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public Teacher toEntity(TeacherRequest request){
        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setMidleName(request.getMiddleName());
        return teacher;
    }

    public TeacherResponse toResponse (Teacher teacher){
        TeacherResponse response = new TeacherResponse();
        response.setId(teacher.getId());
        response.setFullName(teacher.getFirstName() + " " + teacher.getLastName());
        return response;
    }
}
