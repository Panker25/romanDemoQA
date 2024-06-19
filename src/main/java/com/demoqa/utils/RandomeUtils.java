package com.demoqa.utils;

import com.demoqa.entities.Employee;
import com.demoqa.entities.PracticFormEntity;
import com.demoqa.entities.TextBoxEntity;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakerIDN;

public class RandomeUtils {

    Faker faker =new Faker();
  public TextBoxEntity generateRandomeTextEntity(){
      TextBoxEntity textBoxEntity = new TextBoxEntity();
      textBoxEntity.setFullName(faker.name().fullName());
      textBoxEntity.setEmail(faker.internet().emailAddress());
      textBoxEntity.setCurrentAddress(faker.address().fullAddress());
      textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
      return textBoxEntity;
    }
    public PracticFormEntity generateRandomPracticeFormEntity(){
        PracticFormEntity practicFormEntity = new PracticFormEntity();
        practicFormEntity.setFullName(faker.name().fullName());
        practicFormEntity.setLastName(faker.name().lastName());
        practicFormEntity.setEmail(faker.internet().emailAddress());
        practicFormEntity.setMobileNumber(Long.parseLong(faker.phoneNumber().subscriberNumber(10)));
        practicFormEntity.setSubject(faker.superhero().name());
        practicFormEntity.setCurrentAddress(faker.address().fullAddress());
        return practicFormEntity;
    }
    public Employee createMockEmployee(){
      Employee employee = new Employee();

      employee.setFirstname(faker.name().firstName());
      employee.setLastname(faker.name().lastName());
      employee.setAge(faker.number().numberBetween(18,100));
      employee.setEmail(faker.internet().emailAddress());
      employee.setSalary(faker.number().numberBetween(1000000l,2000000l));
      employee.setDepartment(faker.job().position());
      return employee;


    }


}
