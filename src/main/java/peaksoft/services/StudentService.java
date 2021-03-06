package peaksoft.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entities.Company;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.entities.Student;
import peaksoft.exceptions.CompanyNotFoundException;
import peaksoft.exceptions.GroupNotFoundException;
import peaksoft.mappers.edit.StudentEditMapper;
import peaksoft.mappers.view.StudentViewMapper;
import peaksoft.repositories.GroupRepository;
import peaksoft.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;
    private final GroupRepository groupRepository;
    private final StudentEditMapper editMapper;
    private final StudentViewMapper viewMapper;

//    public StudentResponse create (StudentRequest studentRequest) {
//        Student student = editMapper.create(studentRequest);
//        repository.save(student);
//        return viewMapper.viewStudent(student);
//    }
public StudentResponse create (Long id, StudentRequest studentRequest) {
    Group group = groupRepository.findById(id).orElseThrow(()->new GroupNotFoundException(
            "Group with id " + id + " not found!"
    ));

    Student student = editMapper.create(studentRequest);

    group.addStudent(student);
    student.setGroup(group);
    repository.save(student);
    return viewMapper.viewStudent(student);
}
    public StudentResponse update(Long id, StudentRequest studentRequest) {
        Student student = repository.findById(id).get();
        editMapper.update(student, studentRequest);
        return viewMapper.viewStudent(repository.save(student));
    }

    public StudentResponse findById(Long id) {
        Student student = repository.findById(id).get();
        return viewMapper.viewStudent(student);
    }
    public StudentResponse deleteById(Long id) {
        Student student = repository.getById(id);
        repository.delete(student);
        return viewMapper.viewStudent(student);
    }

    public List<StudentResponse> getAllStudents() {
      return viewMapper.view(repository.findAll());
    }

//    public List<StudentResponse> view(List<Student> students) {
//        List<StudentResponse> responses = new ArrayList<>();
//        for (Student student:  students ) {
//            responses.add(viewMapper.viewStudent(student));
//
//        }
//        return responses;
//    }

//    private List<Student> search(String name, Pageable pageable) {
//        String text = name==null? "": name;
//        return repository.searchAndPagination(text.toUpperCase(), pageable);
//    }
//    public StudentResponseView getAllStudentsPagination(String text, int page, int size) {
////        StudentResponseView responseView = new StudentResponseView();
////        Pageable pageable = PageRequest.of(page-1, size);
////        responseView.setResponses(view(search(text, pageable)));
////        return responseView;
////
////    }
}


