package com.example.crudSpringBootDemo.service;

import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class  StudentService {

    // 1. End point listen (/api/student POST)

    // 2. Business logic

    // 3. Interect with DB to store

    // 4. response back to client (Postman)

    private StudentRepository studentRepository;
    private StudentService(StudentRepository  studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student studentReq) {
 // business logic
// store to db
//        System.out.println("Inside StudentService");


        Student studentResponse =  studentRepository.save(studentReq);
//        System.out.println("Exit StudentService");
    return studentResponse;
    }

public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findById(id);

        if (studentResp.isPresent()) {
            return studentResp.get();
        }
        return null;

}

public List<Student> getAllStudent(){
       List<Student> studentList = studentRepository.findAll();

       return studentList;
    }


    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findById(id); // check exist or not

        if (existingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());

   return  studentRepository.save(studentToSave);


 }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if (!isStudent) {
            return false;
        }
  studentRepository.deleteById(id);
        return true;
    }

    }


