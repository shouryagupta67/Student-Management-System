package com.studentmgmt.student_management.repository;


import org.springframework.stereotype.Service;
import com.studentmgmt.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository< Student,Long> {
}
