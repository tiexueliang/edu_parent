package com.edu.service;

import com.edu.domain.Course;
import com.edu.domain.CourseLesson;
import com.edu.domain.CourseSection;

import java.util.List;

public interface CourseContentService {

    public List<CourseSection> findSectionAndLessonByCourseId(int courseId);

    public Course findCourseByCourseId(int courseId);

    public void saveSection(CourseSection section);

    public void updateSection(CourseSection section);

    public void updateSectionStatus(int id,int status);

    public void saveLesson(CourseLesson lesson);

    public void updateLesson(CourseLesson lesson);
}
