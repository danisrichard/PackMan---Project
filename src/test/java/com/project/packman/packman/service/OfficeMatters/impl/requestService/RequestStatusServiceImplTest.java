package com.project.packman.packman.service.OfficeMatters.impl.requestService;

import com.project.packman.packman.error.OfficeMatters.RequestNotFoundException;
import com.project.packman.packman.repository.OfficeMatters.RequestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RequestStatusServiceImplTest {

    @InjectMocks
    private RequestStatusServiceImpl requestStatusService;

    @Mock
    private RequestRepository requestRepository;

    @Test(expected = RequestNotFoundException.class)
    public void addNewStatus() throws RequestNotFoundException {
      when(requestRepository.findById("10")).thenReturn(Optional.empty());
      requestStatusService.findById("10");
    }
}