package com.shopping.repositories;

import com.shopping.entities.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends CrudRepository <Document, Long> {
}
