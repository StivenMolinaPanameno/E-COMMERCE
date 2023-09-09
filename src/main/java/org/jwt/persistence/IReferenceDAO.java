package org.jwt.persistence;

import org.jwt.entities.References;

import java.util.List;
import java.util.Optional;


public interface IReferenceDAO {
    List<References> findAll();
    void save(References ref);
    List<References> findByProduct_Id(Long id);
}
