package com.sih.microfinancing.repository;

import com.sih.microfinancing.entity.BorrowerListing;
import org.springframework.data.repository.CrudRepository;

public interface BorrowerListingRepository extends CrudRepository<BorrowerListing,String> {
}
