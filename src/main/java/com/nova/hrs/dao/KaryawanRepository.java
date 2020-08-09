package com.nova.hrs.dao;

import com.nova.hrs.entity.Karyawan;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface KaryawanRepository extends PagingAndSortingRepository<Karyawan, String> {
}
