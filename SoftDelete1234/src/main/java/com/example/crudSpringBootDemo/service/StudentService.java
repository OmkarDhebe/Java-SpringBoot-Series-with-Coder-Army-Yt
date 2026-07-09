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

        studentReq.setDeleted(false);

        Student studentResponse =  studentRepository.save(studentReq);
//        System.out.println("Exit StudentService");
    return studentResponse;
    }

public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);

        if (studentResp.isPresent()) {
            return studentResp.get();
        }
        return null;

}
//  select * from student where id = 1 AND deleted = false
    // findByIdAndDeletedFalse

public List<Student> getAllStudent(){
       List<Student> studentList = studentRepository.findByIdAndDeletedFalse();

       return studentList;
    }

    //  select * from student where deleted = false;


    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id); // check exist or not

        if (existingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setName(studentReq.getName());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());

        studentToSave.setDeleted(false);

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

    public Boolean deleteStudentSoftly(Long id) {
        //get
        // update delete
        //save


//        Boolean isStudent = studentRepository.existsById(id);
//   return false;

        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedFalse(id);
       if (existingStudent.isEmpty()){
           return false;
       }


       Student studentToSave =  existingStudent.get();
       studentToSave.setDeleted(true);
       studentRepository.save(studentToSave);
       return true;

    }



    }


