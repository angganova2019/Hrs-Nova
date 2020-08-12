package com.nova.hrs.dao;

import com.nova.hrs.entity.Kantor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KantorRepository extends PagingAndSortingRepository<Kantor, String> {
}
