package com.hieu.controller;

import com.hieu.service.ZipCodeValidationService;
import com.hieu.service.ZipCodeValidationServiceImp;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherServiceTest {

    @Test
    public void validZipTest() throws Exception {

        final boolean inValidValue = false;
        final boolean validValue = true;

        ZipCodeValidationService zipCodeValidationService = new ZipCodeValidationServiceImp();
        boolean result = zipCodeValidationService.isValidZipCodeFormat("");
        assertEquals(inValidValue, result);
    }
}