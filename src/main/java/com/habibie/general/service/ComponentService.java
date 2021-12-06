/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.general.service;

import com.habibie.general.dao.ComponentDao;
import com.habibie.general.model.Component;
import java.util.List;

/**
 *
 * @author guest
 */
public interface ComponentService{
    public Component save(Component component);
    public Component findById(int id);
    public Component update(Component component);
    public List<Component> getAll();
}
