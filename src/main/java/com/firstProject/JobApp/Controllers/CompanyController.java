package com.firstProject.JobApp.Controllers;


import com.firstProject.JobApp.Entities.Company;
import com.firstProject.JobApp.ServiceLayer.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company)
    {
        try
        {
            companyService.createCompany(company);
            return new ResponseEntity<>(company, HttpStatus.CREATED);
        }
        catch(IllegalArgumentException ex)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company)
    {
        try
        {
            Optional<Company> updatedCompany = companyService.updateCompany(id, company);
            return updatedCompany.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
        catch(IllegalArgumentException ex)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        if (companyService.deleteCompanyById(id))
        {
            return ResponseEntity.ok("Company with ID " + id + " deleted successfully.");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Company with ID " + id + " not found.");
        }
    }


    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies()
    {
        List<Company> companies = companyService.getAllCompanies();
        if(!companies.isEmpty())
        {
            return  new ResponseEntity<>(companies,HttpStatus.OK);
        }
        else
        {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id)
    {
        Optional<Company> company= companyService.getCompanyById(id);

        return company.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
