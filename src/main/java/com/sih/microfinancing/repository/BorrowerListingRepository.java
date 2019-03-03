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

  @Query(value = "select * from borrower_listing where user_id=?1", nativeQuery = true)
  List<BorrowerListing> getListingById(String borrowerId);

  @Query(value = "select * from borrower_listing where id=?1", nativeQuery = true)
  List<BorrowerListing> getListing(String id);
}
