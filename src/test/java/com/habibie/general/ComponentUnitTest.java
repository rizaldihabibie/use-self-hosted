package com.habibie.general;

import com.habibie.general.dao.ComponentDao;
import com.habibie.general.dao.impl.ComponentDaoImpl;
import com.habibie.general.data.Constant;
import com.habibie.general.model.Component;
import com.habibie.general.service.ComponentService;
import com.habibie.general.service.impl.ComponentServiceImpl;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComponentUnitTest {

    private static ComponentDao componentDao;
    private static ComponentService componentService;
            
    @BeforeAll
    public static void setup(){
        componentDao = mock(ComponentDao.class);
        componentService = new ComponentServiceImpl(componentDao);
    }
    
    @Test
    @Order(1)
    void testDaoSaveMethod() {
        Component componentCB = new Component();
        componentCB.setComponentName("Comsteer");
        componentCB.setDescription("Comsteer untuk stang Old CB150R");
        componentCB.setId(1);
        componentCB.setPrice(200000.0);
        
//        Component componentVario = new Component();
//        componentVario.setComponentName("Headlamp");
//        componentVario.setDescription("Comsteer untuk stang Old CB150R");
//        componentVario.setId(1);
//        componentVario.setPrice(200000.0);
        
        when(componentDao.save(componentCB)).thenReturn(componentCB);
        
        assertEquals(componentService.save(componentCB), componentCB);   
        
    }
    
    @Test
    @Order(2)
    void testDaoFindMethod() {
        Component componentCB = new Component();
        componentCB.setComponentName("Comsteer");
        componentCB.setDescription("Comsteer untuk stang Old CB150R");
        componentCB.setId(1);
        componentCB.setPrice(200000.0);
//        
        Component componentVario = new Component();
        componentVario.setComponentName("Headlamp");
        componentVario.setDescription("Comsteer untuk stang Old CB150R");
        componentVario.setId(2);
        componentVario.setPrice(200000.0);
        
        when(componentDao.findById(1)).thenReturn(componentCB);
        
        when(componentDao.findById(2)).thenReturn(componentVario);
        
        assertEquals(componentService.findById(1), componentCB);
        assertEquals(componentService.findById(2), componentVario);
        
    }
    
    @Test
    @Order(3)
    void testDaoUpdateMethod() {
        
        Component componentVario = new Component();
        componentVario.setComponentName("Headlamp");
        componentVario.setDescription("Comsteer untuk stang Old CB150R");
        componentVario.setId(2);
        componentVario.setPrice(200000.0);
                
        when(componentDao.update(componentVario)).thenReturn(componentVario);
        
        assertEquals(componentService.update(componentVario), componentVario);
    }
    
    @Test
    @Order(4)
    void testDaoGetMethod() {
        
        Component componentVario = new Component();
        componentVario.setComponentName("Headlamp");
        componentVario.setDescription("Comsteer untuk stang Old CB150R");
        componentVario.setId(2);
        componentVario.setPrice(200000.0);
        
        
        Component componentCB = new Component();
        componentCB.setComponentName("Comsteer");
        componentCB.setDescription("Comsteer untuk stang Old CB150R");
        componentCB.setId(1);
        componentCB.setPrice(200000.0);
        
        List<Component> listComponent = new ArrayList<>();
        listComponent.add(componentCB);
        listComponent.add(componentVario);
                
        when(componentDao.getAll()).thenReturn(listComponent);
        
        assertEquals(componentService.getAll(), listComponent);
    }
    

}
