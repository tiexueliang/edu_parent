package com.edu.service;

import com.github.pagehelper.PageInfo;
import com.edu.domain.Resource;
import com.edu.domain.ResourceVo;

public interface ResourceService {

    public PageInfo<Resource> findAllResource(ResourceVo resourceVo);

    void saveResource(Resource resource);

    void updateResource(Resource resource);

    void deleteResource(Integer id);
}
