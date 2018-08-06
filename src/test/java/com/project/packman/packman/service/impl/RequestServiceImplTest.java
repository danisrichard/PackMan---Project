package com.project.packman.packman.service.impl;

import com.project.packman.packman.model.Request;
import com.project.packman.packman.model.RolesType.Priorites;
import com.project.packman.packman.model.RolesType.Status;
import com.project.packman.packman.model.Users;
import com.project.packman.packman.repository.RequestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RequestServiceImplTest {

    @InjectMocks
    private RequestServiceImpl requestService;

    @Mock
    private RequestRepository requestRepository;

    Request request1;
    Request request2;
    Request request3;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        request1 = new Request();
        request1.setId("1");
        request1.setEmail("email1@email.com");
        request1.setPriorites(Collections.singleton(Priorites.HIGH));
        request1.setStatuses(Status.IN_PROGRESS);

        request2 = new Request();
        request2.setId("2");
        request2.setEmail("email2@email.com");
        request2.setPriorites(Collections.singleton(Priorites.LOW));
        request2.setStatuses(Status.NEW_REUQESTS);

        request3 = new Request();
        request3.setId("3");
        request3.setEmail("email3email.com");
        request3.setPriorites(Collections.singleton(Priorites.MEDIUM));
        request3.setStatuses(Status.RESOLVED);

    }

    @Test
    public void saveNewRequest() {
    }

    @Test
    public void testGetAllRequestShouldReturnHashMapWithThreeKeyValuePair() {
        when(requestRepository.findAll()).thenReturn(Arrays.asList(request1,request2,request3));
        HashMap<Status, List<Request>> listHashMap = requestService.getAllRequest();

        listHashMap.forEach((k,v) -> System.out.println(k + " : " + v));
        verify(requestService).getAllRequest();
    }

    @Test
    public void testGetAllRequestShouldReturnHashMapWithOneKeyAndThreeValue() {
        request1.setStatuses(Status.RESOLVED);
        request2.setStatuses(Status.RESOLVED);
        request3.setStatuses(Status.RESOLVED);

        HashMap<Status, List<Request>> benchMarkMap = new HashMap<>();
        benchMarkMap.put(Status.RESOLVED, Arrays.asList(request1,request2,request3));

        when(requestRepository.findAll()).thenReturn(Arrays.asList(request1,request2,request3));
        HashMap<Status, List<Request>> listHashMap = requestService.getAllRequest();

        assertEquals(benchMarkMap,listHashMap);
    }

    public void testGetAllRequestShouldReturnWhenFindAllReturnEmptyList(){
        when(requestRepository.findAll()).thenReturn(Collections.emptyList());
        HashMap<Status, List<Request>> listHashMap = requestService.getAllRequest();

        assertNotNull(listHashMap);
    }

}