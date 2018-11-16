package com.itsight.cuy.service.impl;

import com.itsight.cuy.domain.DocumentType;
import com.itsight.cuy.generic.BaseServiceImpl;
import com.itsight.cuy.repository.DocumentTypeRepository;
import com.itsight.cuy.service.DocumentTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentTypeServiceImpl extends BaseServiceImpl<DocumentTypeRepository> implements DocumentTypeService {

    public DocumentTypeServiceImpl(DocumentTypeRepository repository) {
        super(repository);
    }

    @Override
    public DocumentType save(DocumentType entity) {
        return repository.save(entity);
    }

    @Override
    public DocumentType update(DocumentType entity) {
        return null;
    }

    @Override
    public DocumentType findOne(int id) {
        return repository.findById(id);
    }

    @Override
    public DocumentType findOneWithFT(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<DocumentType> findAll() {
        return repository.findAllbyFlagActivo(true);
    }
}
