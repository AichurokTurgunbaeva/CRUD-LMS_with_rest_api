package peaksoft.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.TeacherRequest;
import peaksoft.dto.response.TeacherResponse;
import peaksoft.services.TeacherService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/teacher")
@Tag(name = "Teacher API", description = "User with role admin can add, update, delete or get all teachers")
public class TeacherController {

    private final TeacherService service;
    @PostMapping
    @Operation(summary = "create teacher", description = "we can create teacher")
    public TeacherResponse create(@RequestBody TeacherRequest request) {
        return service.create(request);
    }
    @PostMapping("{id}")
    @Operation(summary = "update teacher", description = "we can update teacher")
    public TeacherResponse update(@PathVariable long id, @RequestBody TeacherRequest request) {
        return service.update(id, request);
    }

    @GetMapping("{id}")
    @Operation(summary = "find teacher", description = "we can find teacher by id")
    public TeacherResponse findById(@PathVariable long id) {
        return service.findById(id);
    }
    @DeleteMapping("{id}")
    @Operation(summary = "delete teacher", description = "we can teacher group by id")
    public TeacherResponse delete(@PathVariable long id) {
        return service.deleteById(id);
    }

    @GetMapping
    @Operation(summary = "get all teachers", description = "we can get all teachers")
    public List<TeacherResponse> getAllTeachers() {
        return service.getAllTeachers();
    }
}
