package com.sih.microfinancing.repository;

import java.util.List;

import com.sih.microfinancing.entity.BorrowerListing;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerListingRepository extends CrudRepository<BorrowerListing,String> {

  @Query("FROM BorrowerListing")
  List<BorrowerListing> selectAll();

}
