package com.example.crudDtoDemo.repository;

import com.example.crudDtoDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {


}
