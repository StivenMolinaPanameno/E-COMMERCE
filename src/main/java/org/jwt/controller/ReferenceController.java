package org.jwt.controller;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.jwt.controller.DTO.ReferenceDTO;
import org.jwt.entities.References;
import org.jwt.exception.ProductNotFoundException;
import org.jwt.service.IReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product/reference")
public class ReferenceController {
    @Autowired
    IReferenceService service;

    @PostMapping("/{id}")
    public ResponseEntity<?> save(@Valid @RequestBody ReferenceDTO referenceDTO, @PathVariable Long id ,BindingResult bindingResult) throws URISyntaxException, ProductNotFoundException {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Check fields"));        }
        service.save(referenceDTO, id);
        return ResponseEntity.created(new URI("/api/v1/product/reference/" + id)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReference(@PathVariable @Valid Long id){

        List<References> referencesOptional = service.findByProduct_Id(id);
        if(referencesOptional.isEmpty())
        return ResponseEntity.notFound().build();

        return ResponseEntity.ok(referencesOptional);


    }


}
