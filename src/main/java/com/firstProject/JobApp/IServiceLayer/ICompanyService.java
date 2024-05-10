package com.firstProject.JobApp.IServiceLayer;

import com.firstProject.JobApp.Entities.Company;

import java.util.List;
import java.util.Optional;

public interface ICompanyService {
    void createCompany(Company company);

    List<Company> getAllCompanies();

    Optional<Company> getCompanyById(Long id);

    boolean deleteCompanyById(Long id);

    Optional<Company> updateCompany(Long id, Company company);
}
