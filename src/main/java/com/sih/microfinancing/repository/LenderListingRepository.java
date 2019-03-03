package com.sih.microfinancing.repository;

import com.sih.microfinancing.entity.LenderListing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderListingRepository extends CrudRepository<LenderListing,String> {
}
