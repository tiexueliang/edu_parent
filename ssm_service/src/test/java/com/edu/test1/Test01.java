package com.edu.test1;

import com.edu.domain.Course;
import com.edu.domain.CourseVO;
import com.edu.domain.Teacher;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class Test01 {

    @Test
    public void test01() throws InvocationTargetException, IllegalAccessException {

        Course course = new Course();

        CourseVO courseVO = new CourseVO();

        courseVO.setCourseName("123qwer");
        courseVO.setBrief("123qwer");
        courseVO.setCourseImgUrl("http://www.baidu.com");
        courseVO.setDiscounts(12);
        courseVO.setPreviewFirstField("描述");


        courseVO.setTeacherName("daha");
        courseVO.setPosition("Java讲师");

        BeanUtils.copyProperties(course,courseVO);
        System.out.println(courseVO);

        Teacher t = new Teacher();
        BeanUtils.copyProperties(t,courseVO);

        System.out.println(t);

    }
}
