package in.example.crudSpringBootDemo.service;

import in.example.crudSpringBootDemo.dto.CreateStudentRequestDTO;
import in.example.crudSpringBootDemo.dto.CreateStudentResponseDTO;
import in.example.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import in.example.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import in.example.crudSpringBootDemo.entity.Student;
import in.example.crudSpringBootDemo.exception.DuplicateResourceException;
import in.example.crudSpringBootDemo.exception.ResourceNotFoundException;
import in.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentReqDto) {
        Student student = mapToEntity(studentReqDto);

        if(emailExists(student)){
            throw new DuplicateResourceException("Student with email " + student.getEmail() + " already exists");
        }

        Student studentResp = studentRepository.save(student);

    return mapToDto(studentResp);
    }

    public CreateStudentResponseDTO getStudent(Long id) {
//        Optional<Student> studentResp = studentRepository.findById(id);
////
//////        if(studentResp.isPresent()) {
//////            return mapToDto(studentResp.get());
//////        }
//////        return null;
////
////        return  mapToDto(studentResp.get());

//      Student studentResp=   studentRepository.findById(id).orElse(null);
//return mapToDto(studentResp);

    Student studentResp = studentRepository.findById(id) .orElseThrow(() ->
            new ResourceNotFoundException("Student not found with id " + id));

    return mapToDto(studentResp);
    }

    public List<CreateStudentResponseDTO> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();

        return studentList.stream().map(this::mapToDto).toList();
    }


    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq) {
//        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        Student existingStudent = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with "+id+" not found"));
//
//        if(existingStudent.isEmpty()) {
//            return null;
//        }

//        Student studentToSave = existingStudent.get();
//        Student studentToSave = existingStudent;

        existingStudent.setName(studentReq.getName());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());
//        studentToSave.setEmail(studentReq.getEmail());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setDeleted(false);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedStudent =  studentRepository.save(existingStudent);
      return   mapToUpdateDto(savedStudent);
    }

    public Boolean deleteStudent(Long id) {
//        Boolean isStudent = studentRepository.existsById(id);
        Student studentToBeDeleted = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with "+id+" not found"));

//        if(!student) return false;

//        studentRepository.deleteById(id);
        studentRepository.delete(studentToBeDeleted);


        return true;
    }

    public void /* Boolean */ deleteStudentSoftly(Long id) {
//        Optional<Student> existingStudent =
//                studentRepository.findByIdAndDeletedIsFalse(id);
//
//        if(existingStudent.isEmpty()) {
//            return false;
//        }

        Student studentToBeDeleted = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student with "+id+" not found"));

//        Student studentToSave = existingStudent.get();
        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);

//        return true;
    }

    private Student mapToEntity(CreateStudentRequestDTO createStudentRequestDTO) {
        Student student = new Student();
        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setEmail(createStudentRequestDTO.getEmail());
        student.setRollNo(createStudentRequestDTO.getRollNo());
        student.setSubject(createStudentRequestDTO.getSubject());
        student .setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setDeleted(false);
        return student;

    }

    private CreateStudentResponseDTO mapToDto(Student student) {
        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();

        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setEmail(student.getEmail());
        createStudentResponseDTO.setRollNo(student.getRollNo());
        createStudentResponseDTO.setSubject(student.getSubject());
        createStudentResponseDTO.setMessage("Student saved successfully");
        createStudentResponseDTO.setCreatedAt(student.getCreatedAt());
        createStudentResponseDTO.setUpdatedAt(student.getUpdatedAt());

        return createStudentResponseDTO;
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student){
       UpdateStudentResponseDto updateStudentResponseDTO = new UpdateStudentResponseDto();
        updateStudentResponseDTO.setId(student.getId());
        updateStudentResponseDTO.setName(student.getName());
        updateStudentResponseDTO.setAge(student.getAge());
        updateStudentResponseDTO.setEmail(student.getEmail());
        updateStudentResponseDTO.setRollNo(student.getRollNo());
        updateStudentResponseDTO.setSubject(student.getSubject());
        updateStudentResponseDTO.setMessage("Student saved successfully");
//        updateStudentResponseDTO.setCreatedAt(student.getCreatedAt());
        updateStudentResponseDTO.setUpdatedAt(student.getUpdatedAt());

        return updateStudentResponseDTO;
    }


    private boolean emailExists(Student student) {

      return  studentRepository.existsByEmail(student.getEmail());
    }



}
