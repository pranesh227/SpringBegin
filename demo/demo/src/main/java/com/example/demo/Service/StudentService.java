package com.example.demo.Service;

import com.example.demo.Module.Student;
import com.example.demo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo repo;

    public List<Student> getdetailstud() {
        return repo.findAll();
    }

    public String poststud(Student student) {
         repo.save(student);
         return "Added Successfully";
    }

    public String updatedetailstud(Student student) {
         repo.save(student);
         return "Updated";
    }

    public String detetedetailstud(int id) {
        repo.deleteById(id);
        return "Deleted";
    }

    public Student studId(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("UserNotFound"));
    }
    public List<Student> getstuddept(String department){
        return repo.findBydepartment(department);
    }

    public List<Student> sqlquerystud(String gender, String department) {
        return repo.fingBySqlstud(gender,department);
    }

    public List<Student> giveliststud() {
        return repo.findAll();
    }

    public String postfrontstud(int id, String name, String department, String gender) {
        Student ss=new Student(id,name,department,gender);
        repo.save(ss);
        return "Added..";
    }
}
