package com.springboot.filmrentalstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springboot.filmrentalstore.model.*;
@Repository
public interface StoreDAO extends JpaRepository<Store,Integer>{
	
	
}
