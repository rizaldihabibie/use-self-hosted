/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.habibie.general.integration;

import com.habibie.general.SampleRestApplication;
import com.habibie.general.model.Component;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author guest
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ComponentIntegrationTest {
    @LocalServerPort
    private int port;
    
    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private final HttpHeaders headers = new HttpHeaders();
    
    private String createURL(String uri){
        return "http://localhost:"+port+uri;
    }
    
    @Test
    public void testResponseCode(){
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                        createURL("/gallery/components/find?id=1"),
                        HttpMethod.GET, entity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        
        Component componentCB = new Component();
        componentCB.setComponentName("Comsteer");
        componentCB.setDescription("Comsteer untuk stang Old CB150R");
        componentCB.setId(1);
        componentCB.setPrice(200000.0);
        
        response = restTemplate.postForEntity(createURL("/gallery/components"), componentCB, String.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        
        response = restTemplate.exchange(
                        createURL("/gallery/components/find?id=1"),
                        HttpMethod.GET, entity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
