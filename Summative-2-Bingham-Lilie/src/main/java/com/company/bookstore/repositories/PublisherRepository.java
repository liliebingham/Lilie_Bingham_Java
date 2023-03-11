package com.company.bookstore.repositories;

import com.company.bookstore.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
