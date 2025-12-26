package org.example.serveremulator.controller;



import org.example.serveremulator.DTO.attendance.AttendanceRequest;
import org.example.serveremulator.DTO.attendance.AttendanceResponse;
import org.example.serveremulator.mapper.AttendanceMapper;
import org.example.serveremulator.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceService attendanceService;
    private final AttendanceMapper attendanceMapper;

    public AttendanceController(AttendanceService attendanceService, AttendanceMapper attendanceMapper) {
        this.attendanceService = attendanceService;
        this.attendanceMapper = attendanceMapper;
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<AttendanceResponse> getAttendanceByLessonId(@PathVariable Long lessonId) {
        return ResponseEntity.ok(attendanceMapper.toResponse(
                attendanceService.getAttendanceByLessonId(lessonId)
        ));
    }

    @PostMapping
    public ResponseEntity<AttendanceResponse> createAttendance(@RequestBody AttendanceRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(attendanceMapper.toResponse(
                        attendanceService.createAttendance(
                                request.getLessonId(),
                                request.getPresentStudentIds()
                        )
                ));
    }

    @PutMapping("/lesson/{lessonId}")
    public ResponseEntity<AttendanceResponse> updateAttendance(
            @PathVariable Long lessonId,
            @RequestBody AttendanceRequest request) {
        return ResponseEntity.ok(attendanceMapper.toResponse(
                attendanceService.updateAttendance(
                        lessonId,
                        request.getPresentStudentIds()
                )
        ));
    }

    @DeleteMapping("/lesson/{lessonId}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long lessonId) {
        attendanceService.deleteAttendance(lessonId);
        return ResponseEntity.noContent().build();
    }
}