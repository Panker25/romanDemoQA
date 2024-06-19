package com.demoqa.pages;


import lombok.*;
import org.testng.annotations.BeforeClass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder



public class DemoQAPages {
    protected TextBoxPage textBoxPage;
    protected AlertPage alertPage;
    protected PracticeFormPage practiceFormPage ;
    protected ProgressBarPage progressBar;
  protected WebTablesPage webTablesPage;
  @BeforeClass(alwaysRun = true)
  public void setUp (){
      textBoxPage = new TextBoxPage();
      alertPage = new AlertPage();
      progressBar = new ProgressBarPage();
      webTablesPage = new WebTablesPage();

  }
}

