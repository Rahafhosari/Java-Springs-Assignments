package com.javaspring.license.services;

import com.javaspring.license.models.License;
import com.javaspring.license.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicensesService {
    private final LicenseRepository licenseRepository;

    public LicensesService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    // returns all the licenses
    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }

    //find by id
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if (optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }

    // creates a license
    public License createLicense(License x) {
        int y = allLicenses().size();
        if(allLicenses().size()<1){
            x.setNumber(1);
        }
        else
            x.setNumber(++y);
        return licenseRepository.save(x);
    }
}
