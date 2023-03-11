package com.company.bookstore.repositories;
import com.company.bookstore.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.company.bookstore.models.Author;
import org.springframework.stereotype.Component;

@Component
public interface AuthorRepository extends JpaRepository<Author, Integer>{
}
