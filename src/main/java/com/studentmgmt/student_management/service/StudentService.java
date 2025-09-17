package com.studentmgmt.student_management.service;

import com.studentmgmt.student_management.Exception.StudentNotFoundException;
import com.studentmgmt.student_management.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.studentmgmt.student_management.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id)
    {
        return Optional.ofNullable(studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found!")));
    }

    public Student updateStudent(Long id, Student student) {
        return studentRepository.findById(id).map(s -> {
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            return studentRepository.save(s);
        }).orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }
}