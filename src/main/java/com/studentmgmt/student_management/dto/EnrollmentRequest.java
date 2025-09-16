package com.studentmgmt.student_management.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequest {
    private Long studentId;
    private Long courseId;
}
