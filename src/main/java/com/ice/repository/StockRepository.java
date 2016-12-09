package com.ice.repository;

import com.ice.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Chaitanya on 12/6/16.
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
