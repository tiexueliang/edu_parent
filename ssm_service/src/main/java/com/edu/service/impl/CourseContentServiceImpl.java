package com.edu.service.impl;

import com.edu.dao.CourseContentMapper;
import com.edu.domain.Course;
import com.edu.domain.CourseLesson;
import com.edu.domain.CourseSection;
import com.edu.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper contentMapper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId) {

        List<CourseSection> sectionList = contentMapper.findSectionAndLessonByCourseId(courseId);
        return sectionList;
    }

    @Override
    public Course findCourseByCourseId(int courseId) {

        Course course = contentMapper.findCourseByCourseId(courseId);
        return course;
    }

    @Override
    public void saveSection(CourseSection section) {

        //补全信息
        Date date = new Date();
        section.setCreateTime(date);
        section.setUpdateTime(date);

        contentMapper.saveSection(section);
    }

    @Override
    public void updateSection(CourseSection section) {

        //补全信息
        Date date = new Date();
        section.setUpdateTime(date);

        contentMapper.updateSection(section);
    }

    @Override
    public void updateSectionStatus(int id,int status) {

        //封装数据
        CourseSection section = new CourseSection();
        section.setId(id);
        section.setStatus(status);
        section.setUpdateTime(new Date());

        contentMapper.updateSectionStatus(section);
    }

    @Override
    public void saveLesson(CourseLesson lesson) {

        //补全信息
        Date date = new Date();
        lesson.setCreateTime(date);
        lesson.setUpdateTime(date);

        contentMapper.saveLesson(lesson);
    }

    @Override
    public void updateLesson(CourseLesson lesson) {
        //补全信息
        Date date = new Date();
        lesson.setUpdateTime(date);

        contentMapper.updateLesson(lesson);
    }
}
