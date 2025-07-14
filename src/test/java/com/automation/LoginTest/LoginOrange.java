package com.automation.LoginTest;
import org.testng.annotations.Test;
//import org.testng.Assert;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;



public class LoginOrange{
       public WebDriver driver;
       
       @BeforeMethod
       public void setup() throws InterruptedException{
            driver=new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();
            Thread.sleep(10000);
       }
             
       
         @Test(priority=4)
             public void validlogintest() throws InterruptedException{
            Thread.sleep(10000);
            driver.findElement(By.name("username")).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            }

      @Test(priority=5)
        public void Dashboard()throws InterruptedException{

            Thread.sleep(10000);
                
            //checking title of the webpage.
            String pageTitle= driver.getTitle();

            if (pageTitle.equals("OrangeHRM")) {
            System.out.println("Login Successful");
            } else {
            //Reporter.log("Login failed", true);
            System.out.println("Login failed");}
            }

      @Test(priority=2)
         public void Loginwithblank() {
            driver.findElement(By.name("username")).sendKeys("   ");
            driver.findElement(By.name("password")).sendKeys("   ");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            boolean required=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")).isDisplayed();
            System.out.println(required);
            }


      @Test(priority=3)
        public void invalidlogin() throws InterruptedException{
            Thread.sleep(10000);
            driver.findElement(By.name("username")).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            String ActualTitle= driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
            String expectedTitle="Invalid credentials";
            Assert.assertEquals(expectedTitle,ActualTitle);
            }

      @Test(priority=1)
      public void loginwithforgot(){
            driver.findElement(By.name("username")).sendKeys("Admin");
            //driver.findElement(By.name("password")).sendKeys("admin");
            //driver.findElement(By.xpath("//button[@type='submit']")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")).click();

           boolean farm= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div")).isDisplayed();
           System.out.println(farm);
      }

       @Test(priority=1)
       public void resetblank(){
          driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")).click();
          driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[1]/div/div[2]/input")).sendKeys(" ");
          boolean reqreset=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[1]/div/span")).isDisplayed();
          System.out.println(reqreset);
       }


      @Test
       public void adminsearch() throws InterruptedException{
            Thread.sleep(10000);
           validlogintest();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();//clicks admin buttton
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Admin");//adding data 
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();//save button
            boolean searchres=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).isDisplayed();//validating result
            System.out.println(searchres);
       }
  
         @Test
        public void adminbutton() throws InterruptedException{
            validlogintest();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]/span")).click();//click config opens dropdown
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]/ul/li[5]/a")).click(); // clicks module button
            boolean confirm =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6")).isDisplayed();// to confirm
            System.out.println(confirm);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/label/span")).click();// clicks leave module button
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button")).click();// clicks save button
            boolean sucmsg =driver.findElement(By.xpath("//*[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]/p[2]")).isDisplayed();// success message
            System.out.println(sucmsg);
        }

        @Test
        public void pimadd() throws InterruptedException{
            validlogintest();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();//clicks pim module
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a")).click();//clicks add employee
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")).sendKeys("Nitish");//clicks first name
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")).sendKeys("Mittal");//clicks last name
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")).sendKeys("0481");//clicks employeeid
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();//click save 
            boolean newpage=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6")).isDisplayed();//confirmation
            System.out.println(newpage);
        }
        @Test
        public void pimsearchtable() throws InterruptedException{
            validlogintest();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();//clicks pim module
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")).sendKeys("0413");//click to search
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();//clicks search button
            boolean elementsearch=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div")).isDisplayed();
            System.out.println(elementsearch);
        }


        @Test
        public void leavedelete() throws InterruptedException{
            validlogintest();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span")).click();//clicks leave module
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[5]/span")).click();//clicks configure
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[5]/ul/li[4]/a")).click();//clicks holidays 
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[1]")).click();//clicks delete function
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();//click delete confirms
            boolean delete=  driver.findElement(By.xpath("//*[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]/p[2]")).isDisplayed();//confirmation
            System.out.println(delete);
            }

            @Test
            public void leaveEdit() throws InterruptedException{
           validlogintest();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span")).click();//clicks leave module
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[5]/span")).click();//clicks configure
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[5]/ul/li[4]/a")).click();//clicks holidays 
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[3]/div/div[6]/div/button[2]")).click();//clicks edit
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div[2]/div[2]/div/label/span")).click();//clicks radio button
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();//clicks save button
            boolean saveconfirm=driver.findElement(By.xpath("//*[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]/p[2]")).isDisplayed();
            System.out.println(saveconfirm);
          }

           @Test
           public void MyinfoPhoto() throws IOException, InterruptedException{
           validlogintest();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span")).click();//clicks myinfo module
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[2]")).click(); // clicks on image icon
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div/button")).click();//clicks to add image 
            Runtime.getRuntime().exec("C://Users//Expert//Downloads//finalproject//orange//PicUploadAutoit-3.exe");
           }


           @Test
            public void performanceview() throws InterruptedException{
            validlogintest();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[7]/a/span")).click();//clicks performance module
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a")).click();//clicks tracker
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div/div[4]/div/button")).click();//clicks view action button
            boolean viewaction=  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[2]/div[1]")).isDisplayed();
            System.out.println(viewaction);
           }

           @Test
           public void maintenance() throws InterruptedException{
            validlogintest();
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[10]/a/span")).click();//clicks maintenance module
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/form/div[3]/div/div[2]/input")).sendKeys("admin123");//filling password
            boolean maintenancevisible=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/h6")).isDisplayed();
            System.out.println(maintenancevisible);
           }

           @Test
           public void claimdropdown()throws InterruptedException{
            validlogintest();
            Thread.sleep(10000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[11]/a/span")).click();//clicks claim module
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).click();//clicks employee name
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys("A");//Enters A in the field
            driver.findElement(By.xpath("//*[contains(text(), 'Ranga  Akunuri')]")).click();//select the hint
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/input")).click();//clicks referenceID field
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("2");//write 2 to select the hint 
            driver.findElement(By.xpath("//*[contains(text(), '202307180000003')]")).click();//select the hint
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]")).click();//clicks to open dropdown
            driver.findElement(By.xpath("//*[contains(text(), 'Travel')]")).click();//select the option 
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]")).click();//clicks another field 
            driver.findElement(By.xpath("//*[contains(text(), 'Submitted')]")).click();//select the option from another field
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div/input")).sendKeys("2025-02-07");//input date
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[2]/div/div[2]/div/div[2]/div/div/input")).sendKeys("2025-02-11");//inputs another date
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[2]/div/div[3]/div/div[2]/div/div/div[2]")).click();//clicks to open dropsown
            driver.findElement(By.xpath("//*[contains(text(),'Current Employees')]")).click();//select from dropsown
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[3]/button[2]")).click();//click on save button
            boolean notfoundconfirm= driver.findElement(By.xpath("//*[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]/p[2]")).isDisplayed();//confirming 
            System.out.println(notfoundconfirm);
           }




        @AfterMethod
         public void closeweb() throws InterruptedException {
         Thread.sleep(10000);
         driver.close();
         driver.quit();
           }
}