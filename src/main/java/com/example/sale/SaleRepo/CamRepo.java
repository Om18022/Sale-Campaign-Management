package com.example.sale.SaleRepo;

import com.example.sale.Model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CamRepo extends JpaRepository<Campaign, Integer> {
    @Query(value = "select * from campaign where end_date<=:currentDate",nativeQuery = true)
    List<Campaign> findActiveCampaign(String currentDate);
}
