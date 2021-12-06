/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.general.service.impl;

import com.habibie.general.dao.ComponentDao;
import com.habibie.general.dao.impl.ComponentDaoImpl;
import com.habibie.general.model.Component;
import com.habibie.general.service.ComponentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guest
 */
@Service
public class ComponentServiceImpl implements ComponentService{

    private ComponentDao componentDao;

    public ComponentServiceImpl() {
        componentDao = new ComponentDaoImpl();
    }

    public ComponentServiceImpl(ComponentDao componentDao) {
        this.componentDao = componentDao;
    }
    
    @Override
    public Component save(Component component) {
        return componentDao.save(component);
    }

    @Override
    public Component findById(int id) {
        return componentDao.findById(id);
    }

    @Override
    public Component update(Component component) {
        return componentDao.update(component);
    }

    @Override
    public List<Component> getAll() {
        return componentDao.getAll();
    }
    
}
