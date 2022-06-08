package com.edu.dao;

import com.edu.domain.Course;
import com.edu.domain.CourseVO;
import com.edu.domain.Teacher;

import java.util.List;

public interface CourseMapper {

    /**
     * 查询课程信息
     */
    public List<Course> findAllCourse(CourseVO courseVO);

    /**
     * 保存课程信息
     */
    public int saveCourse(Course course);


    /**
     * 保存讲师信息
     * */
    public void saveTeacher(Teacher teacher);


    /**
     * 修改课程信息
     * */
    public void updateCourse(Course course);


    /**
     * 修改讲师信息
     * */
    public void updateTeacher(Teacher teacher);

    /**
     * 修改课程状态
     * */
    public void updateCourseStatus(Course course);

    /**
     * 根据id 获取课程信息
     * */
    public CourseVO findCourseById(int id);

}
