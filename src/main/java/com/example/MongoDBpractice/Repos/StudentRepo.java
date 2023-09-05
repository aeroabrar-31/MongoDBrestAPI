package com.example.MongoDBpractice.Repos;

import com.example.MongoDBpractice.classes.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student,Integer> {


    Student findByName(String name);
}
