/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.general.controller;

import com.habibie.general.model.Component;
import com.habibie.general.service.impl.ComponentServiceImpl;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController
public class Controller {
    
    @Autowired
    private ComponentServiceImpl componentService;   
    
    @GetMapping(path="/gallery/components",produces = "application/json")
    public ResponseEntity test3(HttpServletRequest httpServletRequest) {
        HashMap<String, Object> responseBody = new HashMap();
        responseBody.put("code", "1200");
        responseBody.put("message", "success");
        responseBody.put("data", componentService.getAll());
      return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
    
    @PostMapping(path="/gallery/components",consumes = "application/json")
    public ResponseEntity test4(@RequestBody Component component) {
        HashMap<String, Object> responseBody = new HashMap();
        if(null == component){
            responseBody.put("code", "1401");
            responseBody.put("message", "Data cannnot be empty");
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
        }else{
            if(componentService.save(component).equals(component)){
                responseBody.put("code", "1201");
                responseBody.put("message", "Success");
                return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
            }else{
                responseBody.put("code", "1500");
                responseBody.put("message", "Failed to create data");
                return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    @PutMapping(path="/gallery/components",consumes = "application/json")
    public ResponseEntity test5(@RequestBody Component component) {
        HashMap<String, Object> responseBody = new HashMap();
        if(null == component){
            responseBody.put("code", "1401");
            responseBody.put("message", "Data cannnot be empty");
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
        }else{
            Component result = componentService.update(component);
            if(result.equals(component)){
                responseBody.put("code", "1203");
                responseBody.put("message", "Success");
                return new ResponseEntity<>(responseBody, HttpStatus.OK);
            }else{
                if(result == null){
                    responseBody.put("code", "1404");
                    responseBody.put("message", "Data not found");
                    return new ResponseEntity<>(responseBody, HttpStatus.NOT_MODIFIED);
                }else{
                    responseBody.put("code", "1500");
                    responseBody.put("message", "Failed to create data");
                    return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
    }
    
    @GetMapping(path="/gallery/components/find",consumes = "application/json")
    public ResponseEntity test5(@RequestParam Integer id) {
        HashMap<String, Object> responseBody = new HashMap();
        if(null == id){
            responseBody.put("code", "1401");
            responseBody.put("message", "Empty id");
            return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
        }else{
            Component result = componentService.findById(id);
            if(null != result){
                responseBody.put("code", "1200");
                responseBody.put("message", "Success");
                return new ResponseEntity<>(responseBody, HttpStatus.OK);
            }else{
                if(result == null){
                    responseBody.put("code", "1404");
                    responseBody.put("message", "Data not found");
                    return new ResponseEntity<>(responseBody, HttpStatus.NO_CONTENT);
                }else{
                    responseBody.put("code", "1500");
                    responseBody.put("message", "Failed to create data");
                    return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }
    }
}
