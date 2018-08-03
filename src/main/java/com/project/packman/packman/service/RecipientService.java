package com.project.packman.packman.service;

import com.project.packman.packman.model.Recipient;

import javax.validation.Valid;
import java.util.List;

public interface RecipientService {
    List<Recipient> getAllRecipient();
    Recipient saveRecipient(@Valid Recipient recipient);
}
