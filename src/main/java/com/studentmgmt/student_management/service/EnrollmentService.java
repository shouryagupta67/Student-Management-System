package com.studentmgmt.student_management.service;

import com.studentmgmt.student_management.entity.Course;
import com.studentmgmt.student_management.entity.Enrollment;
import com.studentmgmt.student_management.repository.CourseRepository;
import com.studentmgmt.student_management.repository.EnrollmentRepository;
import com.studentmgmt.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentmgmt.student_management.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    public List<Course> getCoursesByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return student.getEnrollments().stream()
                .map(Enrollment::getCourse)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return course.getEnrollments().stream()
                .map(Enrollment::getStudent)
                .collect(Collectors.toList());
    }

    public void cancelEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}
