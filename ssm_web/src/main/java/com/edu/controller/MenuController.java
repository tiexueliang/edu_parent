package com.edu.controller;

import com.github.pagehelper.PageInfo;
import com.edu.domain.Menu;
import com.edu.domain.MenuVo;
import com.edu.domain.ResponseResult;
import com.edu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询菜单列表信息
     * */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(MenuVo menuVo){

        PageInfo<Menu> pageInfo = menuService.findAllMenu(menuVo);
        ResponseResult result = new ResponseResult(true,200,"响应成功",pageInfo);

        return result;
    }

    /**
     * 回显菜单信息(包括父子菜单的全部信息)
     * */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(@RequestParam int id){

        if(id == -1){
            //添加操作 回显不需要查询 menu信息
            List<Menu> menuList = menuService.findSubMenuListByPid(-1);

            //封装数据
            Map<String,Object> map = new HashMap<>();
            map.put("menuInfo",null);
            map.put("parentMenuList",menuList);

            ResponseResult result = new ResponseResult(true,200,"响应成功",map);
            return result;
        }else{
            //修改操作 回显
            Menu menu = menuService.findMenuById(id);
            List<Menu> menuList = menuService.findSubMenuListByPid(-1);

            Map<String,Object> map = new HashMap<>();
            map.put("menuInfo",menu);
            map.put("parentMenuList",menuList);

            ResponseResult result = new ResponseResult(true,200,"响应成功",map);
            return result;
        }

    }

    /**
     * 新建&修改菜单
     * */
    @RequestMapping("/saveOrUpdateMenu")
    public ResponseResult saveOrUpdateMenu(@RequestBody Menu menu) {

        try {
            if(menu.getId() != null){
                //修改操作
                menuService.updateMenu(menu);
                ResponseResult result = new ResponseResult(true,200,"响应成功",null);
                return result;
            }else{
                //新增操作
                menuService.saveMenu(menu);
                ResponseResult result = new ResponseResult(true,200,"响应成功",null);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
