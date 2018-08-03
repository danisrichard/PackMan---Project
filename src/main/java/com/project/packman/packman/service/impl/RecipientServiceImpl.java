package com.project.packman.packman.service.impl;

import com.project.packman.packman.model.Recipient;
import com.project.packman.packman.repository.RecipientRepository;
import com.project.packman.packman.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class RecipientServiceImpl implements RecipientService {

    @Autowired
    private RecipientRepository recipentRepository;

    @Override
    public List<Recipient> getAllRecipient() {
        return recipentRepository.findAll();
    }

    @Override
    public Recipient saveRecipient(@Valid Recipient recipient) {
        return recipentRepository.save(recipient);
    }
}
