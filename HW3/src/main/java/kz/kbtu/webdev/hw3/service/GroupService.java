package kz.kbtu.webdev.hw3.service;

import kz.kbtu.webdev.hw3.dto.SaveGroupDto;
import kz.kbtu.webdev.hw3.dto.TakeCourseDto;
import kz.kbtu.webdev.hw3.dto.ViewGroupDto;
import kz.kbtu.webdev.hw3.entity.Course;
import kz.kbtu.webdev.hw3.entity.Group;
import kz.kbtu.webdev.hw3.mapper.GroupMapper;
import kz.kbtu.webdev.hw3.repository.CourseRepository;
import kz.kbtu.webdev.hw3.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GroupMapper groupMapper;

    public List<ViewGroupDto> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        List<ViewGroupDto> dto = groupMapper.toDtoList(groups);
        return dto;
    }

    public ViewGroupDto getGroupById(Long id) throws Exception {
        Group group = groupRepository.findById(id).orElse(null);
        if(Objects.isNull(group)) {
            throw new Exception("Group not found");
        }
        ViewGroupDto dto = groupMapper.toDto(group);
        return dto;
    }

    public ViewGroupDto addGroup(SaveGroupDto dto) {
        Group group = groupMapper.toEntity(dto);
        Group savedGroup = groupRepository.save(group);
        ViewGroupDto savedDto = groupMapper.toDto(savedGroup);
        return savedDto;
    }

    public ViewGroupDto updateGroup(Long id, SaveGroupDto dto) throws Exception {
        Group group = groupRepository.findById(id).orElse(null);
        if(Objects.isNull(group)) {
            throw new Exception("Group not found");
        }
        group.setName(dto.getGroupName());
        Group updatedGroup = groupRepository.save(group);
        ViewGroupDto savedDto = groupMapper.toDto(updatedGroup);
        return savedDto;
    }

    public ViewGroupDto takeCourse(TakeCourseDto dto) throws Exception {
        Group group = groupRepository.findById(dto.getGroupId()).orElse(null);
        if(Objects.isNull(group)) {
            throw new Exception("Group not found");
        }
        Course course = courseRepository.findById(dto.getCourseId()).orElse(null);
        if(Objects.isNull(course)) {
            throw new Exception("Course not found");
        }
        group.getCourses().add(course);
        Group groupWithNewCourse = groupRepository.save(group);
        ViewGroupDto updatedDto = groupMapper.toDto(groupWithNewCourse);
        return updatedDto;
    }
}
