package com.example.MongoDBpractice.Controllers;


import com.example.MongoDBpractice.Repos.StudentRepo;
import com.example.MongoDBpractice.classes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class studController {

    @Autowired
    private StudentRepo stRepo;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Student student)
    {
        Student s=this.stRepo.save(student);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getStudents()
    {
        return ResponseEntity.ok(this.stRepo.findAll());
    }

    @GetMapping("/getbyname/{name}")
    public Student getByname(@PathVariable("name") String  name)
    {
        return this.stRepo.findByName(name);
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Student> getByid(@PathVariable("id") int id)
    {
        return this.stRepo.findById(id);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<?> deleteByid(@PathVariable("id") int id)
    {
        this.stRepo.deleteById(id);
        return ResponseEntity.ok("Deleted the user  by id"+id);
    }

    @PutMapping("/updatebyid/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody Student stud)
    {
        Optional<Student> st = stRepo.findById(id);
        stRepo.save(stud);
        return ResponseEntity.ok(stud+"  Updated user !!");

    }



}
