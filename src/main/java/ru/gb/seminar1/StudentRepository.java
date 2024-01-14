package ru.gb.seminar1;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StudentRepository {
    private List<Student> studentList;

    public StudentRepository() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Ilya", "777"));
        studentList.add(new Student("Vladimir", "555"));
        studentList.add(new Student("studentName # 3", "444"));
        studentList.add(new Student("studentName # 4", "777"));
        studentList.add(new Student("studentName # 5", "555"));
        studentList.add(new Student("studentName # 6", "777"));
        studentList.add(new Student("studentName # 7", "444"));
        studentList.add(new Student("studentName # 8", "777"));
        studentList.add(new Student("studentName # 9", "555"));
        studentList.add(new Student("studentName # 10", "777"));
    }

    /**
     * Метод возвращает студента с заданным id (задание 3.1)
     *
     * @param id
     * @return
     */
    public Student getStudentById(long id) {
        return studentList.stream().filter(it -> it.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод возвращает список всех студентов (задание 3.2)
     *
     * @return
     */
    public List<Student> getStudentAll() {
        return List.copyOf(studentList);
    }

    /**
     * Метод возвращает список студентов, чье имя содержит подстроку studentName (задание 3.3)
     *
     * @return
     */
    public List<Student> getStudentBySubstringStudentName(String substringStudentName) {
        return studentList.stream().filter(it -> it.getName().contains(substringStudentName))
                .collect(Collectors.toList());
    }

    /**
     * Метод возвращает список студентов заданной группы (задание 3.4)
     *
     * @param groupName
     * @return
     */
    public List<Student> getStudentByGroup(String groupName) {
        List<Student> list = studentList.stream()
                .filter(it -> Objects.equals(it.getGroupName(), groupName))
                .collect(Collectors.toList());
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }


    /**
     * Метод удаляет студента из списка с заданным id (задание 3.6)
     *
     * @param id
     */

    public void deleteStudentById(long id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentList.remove(student);
            }
        }
    }
}
