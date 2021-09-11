package com.callau.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.callau.dsvendas.dto.SaleSuccessDTO;
import com.callau.dsvendas.dto.SaleSumDTO;
import com.callau.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.callau.dsvendas.dto.SaleSumDTO(sale.seller, SUM(sale.amount)) "
			+ "FROM Sale AS sale GROUP BY sale.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.callau.dsvendas.dto.SaleSuccessDTO(sale.seller, SUM(sale.visited), SUM(sale.deals)) "
			+ "FROM Sale AS sale GROUP BY sale.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}
