package com.edu.petairbnb.service;

import com.edu.petairbnb.model.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService extends BaseService<Owner>{
    //getAvailableCarers(Boolean isAvailable)
        //Add a boolean attribute in account class and get all accounts where is true
    //getAccountByNumOfReviews()
        //Query =
                //SELECT  first_name from accounts,account_reviews
            //where
            //   (select count(account_id) as accounts) and
            //    account_id = accounts.id
            //group by account_id
            //order by account_id asc
    //getPetHistory(ID)
        //Maybe this must be implemented in the booking service. booking will keep a snapshot of everything that is associated in a booking

}
