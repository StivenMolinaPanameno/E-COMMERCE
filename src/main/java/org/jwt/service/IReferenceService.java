package org.jwt.service;

import org.jwt.controller.DTO.ReferenceDTO;
import org.jwt.entities.References;
import org.jwt.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IReferenceService {
    List<References> findAll();
    void save(ReferenceDTO references, Long id) throws ProductNotFoundException;
    List<References> findByProduct_Id(Long id);
}
