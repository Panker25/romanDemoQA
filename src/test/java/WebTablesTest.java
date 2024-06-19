import com.demoqa.entities.Employee;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends BaseTest{

    @Test(description = "Web tab test")
    public void  test123(){
        driver.get("https://demoqa.com/webtables");
        demoQAPages.getWebTablesPage().addNewEmployee(randomeUtils.createMockEmployee());
        demoQAPages.getWebTablesPage().addNewEmployee(randomeUtils.createMockEmployee());

        List<Employee> employees = demoQAPages.getWebTablesPage().getEmployeesFromTable();
        for (Employee employee : employees){
            System.out.println(employee);
        }
        demoQAPages.getWebTablesPage().getEmployeesFromTable1();
        demoQAPages.getWebTablesPage().removeEmail(randomeUtils.createMockEmployee());
        demoQAPages.getWebTablesPage().deleteUser();




        //webTablesPage.deleteEmployeeByEmail("kierra@example.com");

// Повторно получить сотрудников из таблицы и убедиться, что нужный удален
       // employees = webTablesPage.getEmployeesFromTable();
      //  for (Employee emp : employees) {
            //System.out.println(emp);
        }
    }


