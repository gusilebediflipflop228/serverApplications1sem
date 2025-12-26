package org.example.serveremulator.mapper;


import org.example.serveremulator.DTO.subject.SubjectRequest;
import org.example.serveremulator.DTO.subject.SubjectResponse;
import org.example.serveremulator.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {

    public Subject toEntity(SubjectRequest request) {
        Subject subject = new Subject();
        subject.setName(request.getName());
        return subject;
    }

    public SubjectResponse toResponse(Subject subject) {
        SubjectResponse response = new SubjectResponse();
        response.setId(subject.getId());
        response.setName(subject.getName());
        return response;
    }
}