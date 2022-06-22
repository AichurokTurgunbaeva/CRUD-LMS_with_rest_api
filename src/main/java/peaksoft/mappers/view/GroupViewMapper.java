package peaksoft.mappers.view;

import org.springframework.stereotype.Component;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.services.CourseService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class GroupViewMapper {
      public GroupResponse viewGroup(Group group) {
            if(group==null) {
                return null;
            }
            GroupResponse response = new GroupResponse();
            response.setId(group.getId());
            response.setGroupName(group.getGroupName());
            response.setDateOfStart(group.getDateOfStart());
            response.setDateOfFinish(group.getDateOfFinish());
            response.setCourses(group.getCourses());
            response.setCreated(group.getCreated());
            return response;
        }

        public List<GroupResponse> view(List<Group> groups) {
            List<GroupResponse> responses = new ArrayList<>();
            for (Group group:  groups) {
                responses.add(viewGroup(group));
            }
            return responses;
        }

}
