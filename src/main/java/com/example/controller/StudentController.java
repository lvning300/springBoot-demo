package com.example.controller;


import com.example.bean.Student;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping(path = "queryStudentList", method = GET, produces = "application/json")
    @ApiOperation(value = "查询所有学生")
    public List<Student> queryStudentList() {
        mongoTemplate.getDb().getCollectionNames();
        // mongodbConfig.getHost();
        // mongodbConfig.getHost();
        List<Student> studentList = mongoTemplate.findAll(Student.class,"user");
        return studentList;
    }


}
