package com.nediiii.ncu.bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BbsRepository<T> extends JpaRepository<T,Integer>, JpaSpecificationExecutor<T> {
}
