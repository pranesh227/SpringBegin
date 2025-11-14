package com.example.demo.Controller;

import com.example.demo.Module.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentControl {
    @Autowired
    StudentService service;
    @GetMapping("Stud/")
    public List<Student> getstuyd(){
        return service.getdetailstud();
    }
    @PostMapping("student")
    public String enterstud(@RequestBody Student student){
        return service.poststud(student);
    }
    @PutMapping("Update")
    public String updatestrud(@RequestBody Student student){
        return service.updatedetailstud(student);
    }
    @DeleteMapping("Delete/{id}")
    public String deuetestud(@PathVariable("id") int id){
        return service.detetedetailstud(id);
    }
    @GetMapping("StudId/{id}")
    public Student  selectStudId(@PathVariable("id") int id){
        return service.studId(id);
    }
    @GetMapping("Stud/tech/{department}")
    public List<Student> studdept(@PathVariable("department") String department){
        return  service.getstuddept(department);
    }
    @PostMapping("Stud/filter")
    public List<Student> sqlstud(@Param("gender") String gender,@Param("department") String department){
        return service.sqlquerystud(gender,department);

    }

}
