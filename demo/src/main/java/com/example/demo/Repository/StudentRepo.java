package com.example.demo.Repository;

import com.example.demo.Module.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    List<Student> findBydepartment(String department);
    @Query(nativeQuery = true,
    value = "select * from student where gender=:gender and department=:department")
    List<Student> fingBySqlstud(@Param("gender") String gender,@Param("department") String department);
}
