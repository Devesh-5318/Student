package com.project.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    @Transactional
    public Student createStudent(Student student) {

        if(student.getCourses() != null){
            student.getCourses()
                    .forEach(course -> {
                        if (course.getStudents() == null) {
                            course.setStudents(new HashSet<>());
                        }
                        course.getStudents().add(student);
                    });
        }

        return repo.save(student);
    }

    public Student getStudent(Long id) {
        return repo.findById(id).orElse(null);
    }


    @Transactional
    public void deleteStudent(Long id) throws StudentKhoGya{
        if(!repo.existsById(id)){
            throw new StudentKhoGya("Student does not exist");
        }
        repo.deleteById(id);
    }
}
