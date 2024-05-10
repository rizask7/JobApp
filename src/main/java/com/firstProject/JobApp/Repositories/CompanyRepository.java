package com.firstProject.JobApp.Repositories;

import com.firstProject.JobApp.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
