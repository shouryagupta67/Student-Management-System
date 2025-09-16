package com.studentmgmt.student_management.repository;

import com.studentmgmt.student_management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
