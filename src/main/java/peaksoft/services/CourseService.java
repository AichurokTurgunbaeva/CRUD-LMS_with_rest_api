package peaksoft.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.entities.Company;
import peaksoft.entities.Course;
import peaksoft.exceptions.CompanyNotFoundException;
import peaksoft.mappers.edit.CourseEditMapper;
import peaksoft.mappers.view.CourseViewMapper;
import peaksoft.repositories.CompanyRepository;
import peaksoft.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CompanyRepository companyRepository;
    private final CourseRepository repository;
    private final CourseEditMapper editMapper;
    private final CourseViewMapper viewMapper;

    public CourseResponse create (Long id, CourseRequest courseRequest) {
        Company company = companyRepository.findById(id).orElseThrow(()->new CompanyNotFoundException(
                "Company with id " + id + " not found!"
        ));

        Course course = editMapper.create(courseRequest);

        company.addCourse(course);
        course.setCompany(company);
        repository.save(course);
        return viewMapper.viewCourse(course);
    }
    public CourseResponse update(Long id, CourseRequest courseRequest) {
        Course course = repository.findById(id).get();
        editMapper.update(course, courseRequest);
        return viewMapper.viewCourse(repository.save(course));
    }

    public CourseResponse findById(Long id) {
        Course course = repository.findById(id).get();
        return viewMapper.viewCourse(course);
    }
    public CourseResponse deleteById(Long id) {
        Course course = repository.getById(id);
        repository.delete(course);
        return viewMapper.viewCourse(course);
    }

    public List<CourseResponse> getAllCourses() {
        return viewMapper.view(repository.findAll());
    }

//    public List<CourseResponse> view(List<Course> courses) {
//        List<CourseResponse> responses = new ArrayList<>();
//        for (Course course:  courses ) {
//            responses.add(viewMapper.viewCourse(course));
//
//        }
//        return responses;
//    }
}

