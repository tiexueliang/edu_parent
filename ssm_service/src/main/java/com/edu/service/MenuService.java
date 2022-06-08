package com.edu.service;

import com.github.pagehelper.PageInfo;
import com.edu.domain.Menu;
import com.edu.domain.MenuVo;

import java.util.List;

public interface MenuService {

    public PageInfo<Menu> findAllMenu(MenuVo menuVo);

    public Menu findMenuById(int id);

    public List<Menu> findSubMenuListByPid(int pid);

    public void saveMenu(Menu menu);

    public void updateMenu(Menu menu);

    List<Menu> findAllMenu2();
}
