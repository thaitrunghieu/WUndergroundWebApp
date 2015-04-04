package com.hieu.service;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 * Created by Hieu on 4/4/2015.
 */
@Component
public class ZipCodeValidationServiceImp implements ZipCodeValidationService {
    public boolean isValidZipCodeFormat(String zipCode) {
        return zipCode!=null && Pattern.matches("\\d{5}", zipCode.trim());
    }
}
