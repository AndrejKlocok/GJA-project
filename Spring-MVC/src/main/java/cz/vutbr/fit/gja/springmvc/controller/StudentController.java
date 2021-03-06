package cz.vutbr.fit.gja.springmvc.controller;

import cz.vutbr.fit.gja.springmvc.entity.Student;
import cz.vutbr.fit.gja.springmvc.entity.StudentRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Martin Kocour
 * created on 29/12/2018
 *
 *
 * {@link RestController} indicates that the data returned by each method
 * will be written straight into the response body instead of rendering a template.
 * A {@link StudentRepository} is injected by constructor into the controller.
 * We have routes for each operations ({@link GetMapping}, {@link PostMapping}, {@link PutMapping}
 * and {@link DeleteMapping}, corresponding to HTTP GET, POST, PUT, and DELETE calls).
 *
 * https://spring.io/guides/tutorials/rest/
 */
@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository repository) {
        this.studentRepository = repository;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("students/{id}")
    public Student getOneStudent(@PathVariable Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PostMapping("/students")
    public Student newEmployee(@RequestBody Student newStudent) {
        Optional<Student> student = studentRepository.findOne(Example.of(newStudent));
        if (student.isPresent()) {
            throw new DuplicateStudentFoundException(student.get().getId());
        }

        return studentRepository.save(newStudent);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student newStudent) {
        try {
            return studentRepository.findById(id).map(student -> {
                student.setName(newStudent.getName());
                student.setIsicId(newStudent.getIsicId());
                student.setLogin(newStudent.getLogin());
                student.setSigned(newStudent.getSigned());
                return studentRepository.save(student);
            }).orElseGet(() -> {
                newStudent.setId(id);
                return studentRepository.save(newStudent);
            });
        } catch (Exception e) {
            throw new DuplicateStudentFoundException(e.getMessage());
        }
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        try {
            studentRepository.deleteById(id);
        } catch (Exception e) {
            throw new StudentNotFoundException(id);
        }
    }

    public static class StudentNotFoundException extends RuntimeException {
        StudentNotFoundException(Long id) {
            super("Could not find student " + id);
        }
    }

    public static class DuplicateStudentFoundException extends RuntimeException {
        DuplicateStudentFoundException(Long id) {
            super("Found duplicate login with student " + id);
        }

        DuplicateStudentFoundException(String message) {
            super(message);
        }
    }

    @ControllerAdvice
    public static class StudentErrorAdvice {

        /**
         * Handle {@link StudentNotFoundException}.
         *
         * {@link ResponseBody} signals that this advice is rendered
         * straight into the response body.
         * {@link ExceptionHandler} configures the advice to only
         * respond if an {@link StudentNotFoundException} is thrown.
         * {@link ResponseStatus} says to issues an HttpStatus.NOT_FOUND, i.e. an HTTP 404.
         *
         * @param exception Caught exception.
         * @return Exception message.
         */
        @ResponseBody
        @ExceptionHandler(StudentNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String studentNotFoundHandler(StudentNotFoundException exception) {
            return exception.getMessage();
        }

        /**
         * Handle {@link DuplicateStudentFoundException}.
         *
         * {@link ResponseBody} signals that this advice is rendered
         * straight into the response body.
         * {@link ExceptionHandler} configures the advice to only
         * respond if an {@link DuplicateStudentFoundException} is thrown.
         * {@link ResponseStatus} says to issues an HttpStatus.NOT_FOUND, i.e. an HTTP 400.
         *
         * @param exception Caught exception.
         * @return Exception message.
         */
        @ResponseBody
        @ExceptionHandler(DuplicateStudentFoundException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public String duplicateStudentFoundHandler(DuplicateStudentFoundException exception) {
            return exception.getMessage();
        }
    }
}
