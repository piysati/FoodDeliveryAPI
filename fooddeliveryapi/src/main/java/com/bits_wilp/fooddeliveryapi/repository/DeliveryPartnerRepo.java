package com.bits_wilp.fooddeliveryapi.repository;

import com.bits_wilp.fooddeliveryapi.entity.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPartnerRepo extends JpaRepository<DeliveryPartner, Long> {
}
