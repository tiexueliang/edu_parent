package com.edu.dao;

import com.edu.domain.Resource;
import com.edu.domain.ResourceVo;

import java.util.List;

public interface ResourceMapper {


    public List<Resource> findAllResource(ResourceVo resourceVo);


    void saveResource(Resource resource);

    void updateResource(Resource resource);

    void deleteResource(Integer id);
}
