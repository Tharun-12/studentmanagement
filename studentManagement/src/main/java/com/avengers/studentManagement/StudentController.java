package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController
{
  Map<Integer,Student> db = new HashMap<>();

  @Autowired
  StudentService studentService;
  @GetMapping("/get_student")
  public Student getStudent(@RequestParam("admnNo") int admnNo)
  {
    return studentService.getStudent(admnNo);
  }

  // getting information
  @PostMapping("/add_student")    // annotation define the endpoint.
  public String addStudent(@RequestBody Student student)
  {
    return studentService.addStudent(student);
  }
   @DeleteMapping("/delete_student/{id}")
   public String deleteStudent(@PathVariable("id") int id)
   {
     return studentService.deleteStudent(id);
   }

   @PutMapping("/update_student")
   public String updateStudent(@RequestParam("id") int id,@RequestParam("age") int age)
   {
      return studentService.updateStudent(id,age);
   }
}
