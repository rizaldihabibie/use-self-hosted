/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.general.dao.impl;

import com.habibie.general.dao.ComponentDao;
import com.habibie.general.data.Constant;
import com.habibie.general.model.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guest
 */
public class ComponentDaoImpl implements ComponentDao {

    @Override
    public Component save(Component component) {
        if(Constant.LIST_COMPONENT == null){
            Constant.LIST_COMPONENT = new ArrayList<>();
        }
        Constant.LIST_COMPONENT.add(component);
        return component;
    }

    @Override
    public Component findById(int id) {
        Component result = null;
        if(Constant.LIST_COMPONENT != null){
            for(Component comp : Constant.LIST_COMPONENT){
                if(comp.getId() == id){
                    result = comp;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Component update(Component component) {
       Component result = null;
        if(Constant.LIST_COMPONENT != null){
            for(Component comp : Constant.LIST_COMPONENT){
                if(comp.getId() == component.getId()){
                    comp.setComponentName(component.getComponentName());
                    comp.setDescription(component.getDescription());
                    comp.setPrice(component.getPrice());
                    result = comp;
                    break;
                }
            }
        }
        return result; 
    }

    @Override
    public List<Component> getAll() {
        return Constant.LIST_COMPONENT;
    }
    
}
