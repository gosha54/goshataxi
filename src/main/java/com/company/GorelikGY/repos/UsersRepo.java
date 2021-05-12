package com.company.GorelikGY.repos;

import com.company.GorelikGY.domain.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<UsersEntity, Integer> {

}