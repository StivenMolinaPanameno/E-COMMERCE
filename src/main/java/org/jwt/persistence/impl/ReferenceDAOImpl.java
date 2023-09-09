package org.jwt.persistence.impl;

import org.jwt.entities.References;
import org.jwt.persistence.IReferenceDAO;
import org.jwt.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ReferenceDAOImpl implements IReferenceDAO {
    @Autowired
    ReferenceRepository referenceRepository;



    @Override
    public List<References> findAll() {
        return referenceRepository.findAll();
    }

    @Override
    public void save(References ref) {
        referenceRepository.save(ref);
    }

    @Override
    public List<References> findByProduct_Id(Long id) {
        return referenceRepository.findByProduct_Id(id);
    }
}
