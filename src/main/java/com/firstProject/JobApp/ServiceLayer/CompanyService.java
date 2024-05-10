package com.firstProject.JobApp.ServiceLayer;

import com.firstProject.JobApp.Entities.Company;
import com.firstProject.JobApp.IServiceLayer.ICompanyService;
import com.firstProject.JobApp.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void createCompany(Company company) {

        Objects.requireNonNull(company, "Company cannot be Null");
        companyRepository.save(company);

    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        if(companyRepository.existsById(id))
        {
            return companyRepository.findById(id);
        }
        else
        {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try
        {
            companyRepository.deleteById(id);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    @Override
    public Optional<Company> updateCompany(Long id, Company company) {
        return companyRepository.findById(id).map(existingCompany ->
        {
            existingCompany.setName(company.getName());
            existingCompany.setDescription(company.getDescription());
            existingCompany.setJobs(company.getJobs());

            Company updatedCompany = companyRepository.save(existingCompany);
            return Optional.of(updatedCompany);
        }).orElseGet(Optional :: empty);
    }
}
