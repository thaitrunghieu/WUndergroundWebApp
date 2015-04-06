package com.hieu.model;

import org.hibernate.validator.HibernateValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class WeatherValidationTest {

    private LocalValidatorFactoryBean localValidatorFactoryBean;
    private String zipCode;
    private int expectedViolations;

    public WeatherValidationTest(String zipCode, int expectedViolations) {
        this.zipCode = zipCode;
        this.expectedViolations = expectedViolations;
    }

    @Before
    public void setup() {
        localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        localValidatorFactoryBean.afterPropertiesSet();
    }

    @Parameters
    public static Iterable<Object[]> data() {
        int noViolation = 0;
        int zipCodeViolation = 1;

        ArrayList<Object[]> objects = new ArrayList<>();

        // invalid formatted zip codes
        objects.add(new Object[] {"", zipCodeViolation});
        objects.add(new Object[] {"-1234", zipCodeViolation});
        objects.add(new Object[] {"-56789", zipCodeViolation});
        objects.add(new Object[] {"valid", zipCodeViolation});
        objects.add(new Object[] {"0000O", zipCodeViolation});
        objects.add(new Object[] {"123242", zipCodeViolation});

        // valid format zip code with preceding and trailing spaces
        objects.add(new Object[] {"   98008  ", noViolation});

        Random random = new Random();
        // random 10 invalid formatted zip codes
        int randomNumber;
        for (int i = 0; i < 10; i++) {
            randomNumber = random.nextInt(1000);
            objects.add(new Object[] {Integer.toString(randomNumber), zipCodeViolation});
        }

        // random 10 valid formatted zip codes
        int randomZipCode;
        for (int i = 0; i < 10; i++) {
            randomZipCode = random.nextInt(10000);
            objects.add(new Object[] {String.format("%05d", randomZipCode), noViolation});
        }

        return objects;
    }

    @Test
    public void validZipCodeTest() {
        final Weather weather = new Weather(zipCode);
        Set<ConstraintViolation<Weather>> constraintViolations = localValidatorFactoryBean.validate(weather);
        assertTrue(constraintViolations.size() == expectedViolations);
    }
}
