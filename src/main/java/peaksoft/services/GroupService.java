package peaksoft.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entities.Group;
import peaksoft.mappers.edit.GroupEditMapper;
import peaksoft.mappers.view.GroupViewMapper;
import peaksoft.repositories.GroupRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository repository;
    private final GroupEditMapper editMapper;
    private final GroupViewMapper viewMapper;

    public GroupResponse create (GroupRequest groupRequest) {
        Group group = editMapper.create(groupRequest);
        repository.save(group);
        return viewMapper.viewGroup(group);
    }

    public GroupResponse update(Long id, GroupRequest groupRequest) {
        Group group = repository.findById(id).get();
        editMapper.update(group, groupRequest);
        return viewMapper.viewGroup(repository.save(group));
    }

    public GroupResponse findById(Long id) {
        Group group = repository.findById(id).get();
        return viewMapper.viewGroup(group);
    }
    public GroupResponse deleteById(Long id) {
        Group group = repository.getById(id);
        repository.delete(group);
        return viewMapper.viewGroup(group);
    }

    public List<GroupResponse> getAllGroups() {
        return viewMapper.view(repository.findAll());
    }

//    public List<GroupResponse> view(List<Group> groups) {
//        List<GroupResponse> responses = new ArrayList<>();
//        for (Group group:  groups ) {
//            responses.add(viewMapper.viewGroup(group));
//
//        }
//        return responses;
//    }
}
