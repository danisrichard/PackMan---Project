package com.project.packman.packman.service.impl;

import com.project.packman.packman.repository.RequestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import sun.dc.pr.PRError;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RequestStatusServiceImplTest {

    @InjectMocks
    private RequestStatusServiceImpl requestStatusService;

    @Mock
    private RequestRepository requestRepository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddNewStatusShouldWhen() {

    }
}