package com.pw24.calcadatebase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pw24.calcadatebase.domain.Calca;

public interface CalcaRepository extends JpaRepository <Calca, String> {

    
}