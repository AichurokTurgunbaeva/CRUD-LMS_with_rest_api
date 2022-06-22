package peaksoft.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.dto.response.CourseResponse;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.repositories.CourseRepository;
import peaksoft.repositories.GroupRepository;
import peaksoft.services.CompanyService;
import peaksoft.services.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/course")
@Tag(name = "Course API", description = "User with role admin can add, update, delete or get all courses")
public class CourseController {

    private final CourseService service;
    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;

    @PostMapping
    @Operation(summary = "create course", description = "we can create course")
    public CourseResponse create(@RequestBody CourseRequest request) {
        return service.create(request.getCompanyId(), request);
    }

    @PutMapping("{id}")
    @Operation(summary = "update course", description = "we can update course")
    public CourseResponse update(@PathVariable long id, @RequestBody CourseRequest request) {
        return service.update(id, request);
    }

    @PutMapping("/{courseId}/groups/{groupId}")
    Course addGroupToCourse(
            @PathVariable Long courseId,
            @PathVariable Long groupId
    ) {
        Course course = courseRepository.findById(courseId).get();
        Group group = groupRepository.findById(groupId).get();
        course.addGroup(group);
        return courseRepository.save(course);
    }

    @GetMapping("{id}")
    @Operation(summary = "find course", description = "we can find course by id")
    public CourseResponse findById(@PathVariable long id) {
        return service.findById(id);
    }
    @DeleteMapping("{id}")
    @Operation(summary = "delete course", description = "we can delete course by id")
    public CourseResponse delete(@PathVariable long id) {
        return service.deleteById(id);
    }

    @GetMapping
    @Operation(summary = "get all courses", description = "we can get all courses")
    public List<CourseResponse> getAllCourses() {
        return service.getAllCourses();
    }

}
