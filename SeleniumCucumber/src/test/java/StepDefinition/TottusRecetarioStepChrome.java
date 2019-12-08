package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TottusRecetarioStepChrome {


    public static  WebDriver driver;
    public static String ruta;
    ChromeOptions chromeoptios;

        @Given("Dado que estoy en el portal de Google")
        public void dado_que_estoy_en_el_portal_de_Google () {

            System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\Chrome\\chromedriver.exe");
            //los ejecutables estan adjuntos en este proyecto en la carpeta WebDrivers, Copiar la carpeta en C:

            //Ingreso a Google
            chromeoptios = new ChromeOptions();
            driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();

        }

        @When("Escribo tottus sucursales en el buscador")
        public void escribo_tottus_sucursales_en_el_buscador () {

          //Ingreso la palabra Sucursales Tottus en el Buscador de google
          WebElement busqueda = driver.findElement(By.name("q"));
          busqueda.sendKeys("Tottus Sucursales");

         }

        @When("Presiono enter")
        public void presiono_enter () {

            //Presiono enter paara ingresar
            WebElement Cuerpo = driver.findElement(By.name("q"));
            Cuerpo.sendKeys(Keys.ENTER);

         }

        @Then("Me muestra el resultado de la busqueda")
        public void me_muestra_el_resultado_de_la_busqueda () {

            WebElement we = driver.findElement(By.className("rISBZc"));
            String altAttribute = we.getAttribute("alt");

         if(altAttribute ==null || altAttribute !="" || altAttribute != " "){

            //Imprime si esta visualizando el mapa de google maps
            System.out.println("Estoy visualizando el " + altAttribute);
         }

        }

        @Given("Dado que estoy en la pag de resultados de Google")
        public void dado_que_estoy_en_la_pag_de_resultados_de_Google () {

            //Captura URL actual
            ruta = driver.getCurrentUrl();
            System.out.println("Estoy en la pagina de resultados de Google "+ ruta);

        }

        @When("Doy clic a el enlace de Tottus nataniel Cox")
        public void doy_clic_a_el_enlace_de_Tottus_nataniel_Cox () {

            WebElement Opcion1 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[2]/div/div[4]/div[1]/div[1]/div/div/a[1]/div/span/div[1]/span"));
            String Lugar1 = Opcion1.getText();

            WebElement Opcion2 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[2]/div/div[4]/div[1]/div[2]/div[2]/div/a[1]/div/span/div[1]/span"));
            String Lugar2 = Opcion2.getText();

            WebElement Opcion3 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[2]/div/div[4]/div[1]/div[3]/div[2]/div/a[1]/div/span/div[1]/span"));
            String Lugar3 = Opcion3.getText();

            if (Lugar1.equals("Nataniel Cox 620")) {

                 System.out.println("Nataniel Cox es la primer opcion");
                 WebElement Ingreso = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[2]/div/div[4]/div[1]/div[1]/div/div/a[1]/div/div[2]/span"));
                 Ingreso.click();
            }
             if (Lugar2.equals("Nataniel Cox 620")) {

                System.out.println("Nataniel Cox es la segunda opción");
                 WebElement Ingreso = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[2]/div/div[4]/div[1]/div[2]/div[2]/div/a[1]/div/div[2]/span"));
                 Ingreso.click();
             }
             if (Lugar3.equals("Nataniel Cox 620")) {

                System.out.println("Nataniel Cox es la tercera opción");
                WebElement Ingreso = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[2]/div/div[4]/div[1]/div[3]/div[2]/div/a[1]/div/div[2]/span"));
                Ingreso.click();

            }
        }

        @Then("Me muestra en google maps la opcion para ingresar")
        public void me_muestra_en_google_maps_la_opcion_para_ingresar () {

            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement selectGender = wait.until(ExpectedConditions.elementToBeClickable(By.className("LrzXr")));
            WebElement fichaNataniel = driver.findElement(By.className("LrzXr"));
            String FichaNataniel = fichaNataniel.getText();

            if (FichaNataniel.equals("Nataniel Cox 620, Santiago, Región Metropolitana")) {
                 System.out.println("Estoy en la ficha de google maps correcta  " + FichaNataniel);
            }

        }

        @Given("Dado que estoy en la ficha de nataniel Cox de Maps")
            public void dado_que_estoy_en_la_ficha_de_nataniel_Cox_de_Maps () {

            //Captura URL actual
            ruta = driver.getCurrentUrl();
        }

        @When("Doy clic al boton sitio web")
        public void doy_clic_al_boton_sitio_web () {

            //Doy click en el boton Sitio Web de la ficha de Google maps
            WebElement BotonSitioWeb = driver.findElement(By.className("QqG1Sd"));
            BotonSitioWeb.click();
        }

        @Then("Ingreso al portal de tottus")
            public void ingreso_al_portal_de_tottus () {

            ruta = driver.getCurrentUrl();
            //Valido que estoy en tottus
             if (ruta.equals("https://www.tottus.cl/tottus/")) {
                System.out.println("Estoy en Tottus " + ruta);
             }
        }

        @Given("Dado que estoy en la pagina de tottus")
        public void dado_que_estoy_en_la_pagina_de_tottus () {

            //capturo la ruta
            ruta = driver.getCurrentUrl();

        }

        @When("Doy clic al boton de recetas")
        public void doy_clic_al_boton_de_recetas () {

            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement BotonRecetas = wait.until(ExpectedConditions.elementToBeClickable(By.id("new_tottus_nav_cliente_recetas")));
            BotonRecetas = driver.findElement(By.id("new_tottus_nav_cliente_recetas"));
            BotonRecetas.click();

        }

        @Then("Ingreso al portal de recetas de tottus en una nueva ventana")
        public void ingreso_al_portal_de_recetas_de_tottus_en_una_nueva_ventana () {

            //Cambio de ventana
             ArrayList ventanas = new ArrayList(driver.getWindowHandles());
             driver.switchTo().window(ventanas.get(1).toString());
             ruta = driver.getCurrentUrl();

             if (ruta.equals("http://www.tottusrecetas.cl/")) {
                  System.out.println("Estoy en TottusRecetas " + ruta);
             }
        }


        @Given("Dado que estoy en la pagina de recetas de tottus")
        public void dado_que_estoy_en_la_pagina_de_recetas_de_tottus () {

            //Capturo la ruta
            ruta = driver.getCurrentUrl();
        }

        @When("Doy clic al boton de nivel alto y voy al enlace de la receta de  rollitos de canela")
        public void doy_clic_al_boton_de_nivel_alto () {

            //Me ubico en el boton de nivel alto
            String UbicarmeBotonAlto = Keys.chord(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.RETURN);
            WebElement enlace = driver.findElement(By.tagName("Body"));
            enlace.sendKeys(UbicarmeBotonAlto);
            driver.get("http://www.tottusrecetas.cl/index.php/receta/?corona-de-rollitos-de-canela_26");
        }


        @Then("Estoy en la receta Corona de rollitos de canela")
        public void estoy_en_la_receta_Corona_de_rollitos_de_canela () {

            WebElement nombrereceta = driver.findElement(By.tagName("strong"));
            String NombreReceta = nombrereceta.getText();

            //Valido que estoy en la receta de corona de rollitos de canela
            if (NombreReceta.equals("CORONA DE ROLLITOS DE CANELA")) {
                System.out.println("Estoy en la receta de  " + NombreReceta);
            }

        }

        @Given("Dado que estoy en la receta de rollitos e canela")
        public void dado_que_estoy_en_la_receta_de_rollitos_e_canela () {
            //Captura la URL
            ruta = driver.getCurrentUrl();
        }

        @When("Busco si existe canela y azucar rubia")
        public void busco_si_existe_canela_y_azucar_rubia () {


            int ExisteARubia = 0;
            int ExisteCanela = 0;
            int Canela;
            int AzucarRubia;

            List<WebElement> ingredientes = driver.findElements(By.tagName("p"));

            for (WebElement ingrediente : ingredientes) {

                ingrediente.toString();
                Canela = (ingrediente.getText()).indexOf("canela");
                AzucarRubia = (ingrediente.getText()).indexOf("azúcar rubia");

                if (Canela != -1) { ExisteCanela = 1; }

                if (AzucarRubia != -1) {  ExisteARubia = 1;  }

            }

            if (ExisteCanela == 1) {
                 System.out.println("RECETA CONTIENE CANELA");
            } else {
                System.out.println("RECETA NO CONTIENE CANELA");
            }

            if (ExisteARubia == 1) {
                 System.out.println("RECETA CONTIENE AZUCAR RUBIA");
            } else {
                 System.out.println("RECETA NO CONTIENE AZUCAR RUBIA");
            }

        }

        @When("Cierro Receta")
        public void cierro_Receta () {

            driver.close();

        }

        @Then("Me quedo en la pagina principal de tottus")
        public void me_quedo_en_la_pagina_principal_de_tottus () {

            ArrayList ventanas = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window(ventanas.get(0).toString());
            ruta = driver.getCurrentUrl();
            System.out.println("Estoy en la pagina de Tottus " + ruta);
        }
    }
