package in.example.crudSpringBootDemo.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDTO {

    @NotBlank(message = "name cannot be empty/null or blank")
    @Size(min = 2 ,max = 50 , message = "name character should between 2 to 50 character long")
    private String name;
    @NotBlank(message = "Student email cannot be blank")
    @Email(message = "Student email must be valid")
    private String email;
    @NotNull(message =  " Age is required")
    @Min(value = 18, message = "Student must be 18 years old")
    private int age;

    @NotNull(message = "Roll number is required")
    private int rollNo;
    @NotBlank(message = "subject is required")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
