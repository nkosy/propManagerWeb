/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nkosy.propertymanager.repository;

import com.nkosy.propertymanager.domain.SubContractorManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nkosy
 */
@Repository
public interface ContractorManagerRepo extends JpaRepository<SubContractorManager, Long> { 
}
