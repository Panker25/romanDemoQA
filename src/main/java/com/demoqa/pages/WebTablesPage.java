package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class WebTablesPage extends BasePage {

    @FindBy (id = "addNewRecordButton")
    public WebElement addNewBtn;

    @FindBy(id = "firstName")
    public WebElement firstnameInput;

    @FindBy(id = "lastName")
    public  WebElement lastnameInput;

    @FindBy(id = "age")
    public WebElement ageInput;

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "salary")
    public  WebElement salaryInput;

    @FindBy(id = "department")
    public  WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;
    @FindBy(id = "edit-record-5")
    public WebElement edited;
    @FindBy(id = "userEmail")
    public WebElement emailInput2;
    @FindBy(id = "delete-record-1")
    public  WebElement kiera1;

   public String email1 = "appozit@mal.ru";

    public ArrayList <WebElement> email (){
        List<WebElement> rows = DriverManager.getDriver().findElements(By.id("userEmail"));
        ArrayList<WebElement>  email = new ArrayList<>();
        for (int i = 0; i < rows.size()-1; i++) {
            for (int j = i + 1; j < rows.size(); j++) {
                if (rows.get(i).equals(rows.get(j))){
                    email.add(rows.get(i));

                }
            }

        }return email;


    }
    public WebTablesPage addNewEmployee(Employee employee){
        webElementActions.click(addNewBtn)
                .sendKeys(firstnameInput,employee.getFirstname())
                .sendKeys(lastnameInput,employee.getLastname())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(emailInput,email1)
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput ,employee.getDepartment())
                .click(submitBtn);

        return  this;
    }

    public ArrayList<Employee> getEmployeesFromTable(){
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>();

        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]","");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]","");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty()
                    || salaryText.isEmpty() || department.isEmpty()){
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim());

            employees.add(new  Employee(firstName,lastName,age,email,salary,department));

        }
        return  employees;
    }

    public ArrayList<String> getEmployeesFromTable1() {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));
        ArrayList<String> email = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String emailSpisok = cells.get(3).getText();
            email.add(emailSpisok);
        }

        // Проверка наличия дубликатов
        boolean hasDuplicates = email.stream().distinct().count() != email.size();

        try {
            if (hasDuplicates) {
                try {

                    throw new RuntimeException("В списке есть дубликаты.");
                }catch (Exception e){
                    System.err.println("поменяйте почту " + email1);
                }
            } else {
                System.out.println("В списке нет дубликатов.");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return email;
    }
    public WebTablesPage removeEmail(Employee employee){
        webElementActions.click(edited);
        emailInput2.clear();
        webElementActions.sendKeys(emailInput2, employee.getEmail()).click(submitBtn);
        return this;
    }
    public WebTablesPage deleteUser (){
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));
        for (WebElement ciera : rows){
            List<WebElement> employee = ciera.findElements(By.cssSelector(".rt-td"));
            String userEmailDelete = employee.get(3).getText();
            if (userEmailDelete.contains("cierra@example.com")){
                webElementActions.click(kiera1);
                break;
            }

        }
        return this;

    }
}


//    // Метод для удаления сотрудника по email
//    public WebTablesPage deleteEmployeeByEmail(String email) {
//        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));
//        for (WebElement row : rows) {
//            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
//            if (cells.size() > 3 && cells.get(3).getText().equals(email)) {
//                WebElement deleteButton = row.findElement(By.cssSelector("span[id^='delete-record-']"));
//                deleteButton.click();
//                break;
//            }
//        }
//        return this;











