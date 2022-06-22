package peaksoft.mappers.edit;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.entities.Company;

import java.time.LocalDate;
@Component
public class CompanyEditMapper {
    public Company create(CompanyRequest request) {
        if(request==null) {
            return null;
        }
        Company company = new Company();
        company.setCompanyName(request.getCompanyName());
        company.setLocatedCountry(request.getLocatedCountry());
        company.setCreated(LocalDate.now());
        return company;
    }

    public void update(Company company, CompanyRequest request) {
        company.setCompanyName(request.getCompanyName());
        company.setLocatedCountry(request.getLocatedCountry());
        company.setCreated(LocalDate.now());
    }
}

