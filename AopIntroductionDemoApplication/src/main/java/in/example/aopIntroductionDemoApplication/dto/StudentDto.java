package in.example.aopIntroductionDemoApplication.dto;


public class StudentDto {

    private String name;
    private int age;
    private int rollNo;
    private String message;

//    public StudentDto(int age, String name, int rollNo, String message) {
//        this.age = age;
//        this.name = name;
//        this.rollNo = rollNo;
//        this.message = message;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
