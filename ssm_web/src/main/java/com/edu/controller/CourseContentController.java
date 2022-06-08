package com.edu.controller;

import com.edu.domain.Course;
import com.edu.domain.CourseLesson;
import com.edu.domain.CourseSection;
import com.edu.domain.ResponseResult;
import com.edu.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService contentService;

    /**
     * 查询课程内容
     * */
    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(@RequestParam int courseId){

        try {
            //调用service
            List<CourseSection> sectionList = contentService.findSectionAndLessonByCourseId(courseId);

            //封装数据并返回
            ResponseResult result = new ResponseResult(true,200,"响应成功",sectionList);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 回显章节对应的课程信息
     * */
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(@RequestParam int courseId){

        try {
            //调用service
            Course course = contentService.findCourseByCourseId(courseId);
            ResponseResult result = new ResponseResult(true,200,"响应成功",course);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存&修改课时信息
     */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection( @RequestBody CourseSection section) {

        try {
            //判断携带id是修改操作否则是插入操作
            if(section.getId() == null){
                contentService.saveSection(section);
                return new ResponseResult(true,200,"响应成功",null);
            }else{
                contentService.updateSection(section);
                return new ResponseResult(true,200,"响应成功",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 修改章节状态
     * 状态，0:隐藏；1：待更新；2：已发布
     * */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(@RequestParam int id,@RequestParam int status){

        try {
            contentService.updateSectionStatus(id,status);

            //封装最新的状态信息
            Map<String,Integer> map = new HashMap<>();
            map.put("status",status);

            ResponseResult result = new ResponseResult(true,200,"响应成功",map);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存&修改课时
     * */
    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResult saveOrUpdateLesson(@RequestBody CourseLesson lesson){

        try {
            if(lesson.getId() == null){
                contentService.saveLesson(lesson);
                return new ResponseResult(true,200,"响应成功",null);

            }else{
                contentService.updateLesson(lesson);
                return new ResponseResult(true,200,"响应成功",null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
