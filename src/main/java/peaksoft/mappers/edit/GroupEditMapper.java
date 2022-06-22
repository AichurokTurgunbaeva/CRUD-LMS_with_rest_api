package peaksoft.mappers.edit;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.GroupRequest;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.repositories.GroupRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class GroupEditMapper {

    private final GroupRepository groupRepository;

    public GroupEditMapper(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group create(GroupRequest request) {
        if (request == null) {
            return null;
        }
        Group group = new Group();
        group.setGroupName(request.getGroupName());
        group.setDateOfStart(request.getDateOfStart());
        group.setDateOfFinish(request.getDateOfFinish());
        group.setCourses(request.getCourses());
        return group;
    }

    public void update(Group group, GroupRequest request) {
        group.setGroupName(request.getGroupName());
        group.setDateOfStart(request.getDateOfStart());
        group.setDateOfFinish(request.getDateOfFinish());
        group.setCourses(request.getCourses());
        group.setCreated(LocalDate.now());
    }
}
