package com.studentmgmt.student_management.Exception;

public class CourseNotFoundException extends RuntimeException{
      public CourseNotFoundException(String message){
          super(message);
      }
}
