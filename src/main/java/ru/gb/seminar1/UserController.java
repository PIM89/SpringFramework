package ru.gb.seminar1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    StudentRepository studentRepository;

    @Autowired
    public UserController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Метод возвращает информацию о студенте с заданным id (задание 3.1)
     * @param id
     * @return
     */
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentRepository.getStudentById(id);
    }

    /**
     * Метод возвращает информацию обо всех студентах (задание 3.2)
     *
     * @return
     */
    @GetMapping("/student")
    public List<Student> getStudentAll() {
        return studentRepository.getStudentAll();
    }

    /**
     * Метод возвращает список студентов, чье имя содержит заданную подстроку (задание 3.3)
     *
     * @param substringStudentName
     * @return
     */

    @GetMapping("/student/search")
    public List<Student> getStudentBySubstringStudentName(@RequestParam String substringStudentName) {
        return studentRepository.getStudentBySubstringStudentName(substringStudentName);
    }

    /**
     * Метод возвращает список студентов с заданной группы (задание 3.4)
     *
     * @param groupName
     * @return
     */

    @GetMapping("/group/{groupName}/student")
    public List<Student> getStudentByGroup(@PathVariable String groupName) {
        return studentRepository.getStudentByGroup(groupName);
    }

    /**
     * Метод создает нового студента и возвращает список всех студентов (задание 3.5)
     * @param student
     * @return
     */

    @PostMapping(value = "/student/add")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Student> addStudent(@RequestBody Student student) {
        studentRepository.addStudent(student);
        return studentRepository.getStudentAll();
    }


    /**
     * Метод удаляет информацию о студенте с заданным id и возвращает список (задание 3.6)
     * @param id
     * @return
     */

    @DeleteMapping("/student/{id}")
    public List<Student> deleteStudentById(@PathVariable long id) {
        studentRepository.deleteStudentById(id);
        return studentRepository.getStudentAll();
    }
}
