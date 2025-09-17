package com.studentmgmt.student_management.controller;
import com.studentmgmt.student_management.Exception.CourseNotFoundException;
import com.studentmgmt.student_management.Exception.StudentNotFoundException;
import com.studentmgmt.student_management.dto.EnrollmentRequest;
import com.studentmgmt.student_management.entity.Course;
import com.studentmgmt.student_management.entity.Enrollment;
import com.studentmgmt.student_management.entity.Student;
import com.studentmgmt.student_management.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public  ResponseEntity<List<Course>> getCoursesByStudent(@PathVariable Long id) {
        List<Course> courses = enrollmentService.getCoursesByStudent(id);
        if(courses.isEmpty()){
            throw new CourseNotFoundException("Course Not Found");
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public  ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable Long id) {
        List<Student> students = enrollmentService.getStudentsByCourse(id);
        if(students.isEmpty()){
            throw new StudentNotFoundException("Student Not Found");
        }
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void cancelEnrollment(@PathVariable Long id) {
        enrollmentService.cancelEnrollment(id);
    }
}
