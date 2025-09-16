package com.studentmgmt.student_management.controller;
import com.studentmgmt.student_management.dto.EnrollmentRequest;
import com.studentmgmt.student_management.entity.Course;
import com.studentmgmt.student_management.entity.Enrollment;
import com.studentmgmt.student_management.entity.Student;
import com.studentmgmt.student_management.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public Enrollment enrollStudent(@RequestBody EnrollmentRequest request) {
        return enrollmentService.enrollStudent(request.getStudentId(), request.getCourseId());
    }

    @GetMapping("/student/{id}")
    public List<Course> getCoursesByStudent(@PathVariable Long id) {
        return enrollmentService.getCoursesByStudent(id);
    }

    @GetMapping("/course/{id}")
    public List<Student> getStudentsByCourse(@PathVariable Long id) {
        return enrollmentService.getStudentsByCourse(id);
    }

    @DeleteMapping("/{id}")
    public void cancelEnrollment(@PathVariable Long id) {
        enrollmentService.cancelEnrollment(id);
    }
}
