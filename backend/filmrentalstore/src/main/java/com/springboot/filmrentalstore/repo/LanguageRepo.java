package com.springboot.filmrentalstore.repo;

import com.springboot.filmrentalstore.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LanguageRepo extends JpaRepository<Language,Integer> {

}
