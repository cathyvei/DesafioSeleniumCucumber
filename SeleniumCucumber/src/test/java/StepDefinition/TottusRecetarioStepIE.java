package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class TottusRecetarioStepIE {


        public static  WebDriver driver;
        InternetExplorerOptions internetExplorerOptions;
        public static String ruta;

    @Given("Dado que estoy en el portal de Google IE")
    public void dado_que_estoy_en_el_portal_de_Google_IE() {
        System.setProperty("webdriver.ie.driver", "c:\\WebDrivers\\IExplorer\\IEDriverServer.exe");
        //los ejecutables estan adjuntos en este proyecto en la carpeta WebDrivers, Copiar la carpeta en C:

        //Voy a la URL de google
        internetExplorerOptions = new InternetExplorerOptions();
        driver = new InternetExplorerDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @When("Escribo tottus sucursales en el buscador IE")
    public void escribo_tottus_sucursales_en_el_buscador_IE() {

        //Ingreso tottus sucursales en el buscador
        WebElement busqueda = driver.findElement(By.name("q"));
        busqueda.sendKeys("Tottus Sucursales");

    }

    @When("Presiono enter IE")
    public void presiono_enter_IE() {

        WebElement Cuerpo = driver.findElement(By.name("q"));
        Cuerpo.sendKeys(Keys.ENTER);

    }

    @Then("Me muestra el resultado de la busqueda IE")
    public void me_muestra_el_resultado_de_la_busqueda_IE() {

        WebElement we = driver.findElement(By.className("rISBZc"));
        String altAttribute = we.getAttribute("alt");

        if(altAttribute ==null || altAttribute !="" || altAttribute != " "){

            //Imprime si esta visualizando el mapa de google maps
            System.out.println("Estoy visualizando el " + altAttribute);
        }

    }

    @Given("Dado que estoy en la pag de resultados de Google IE")
    public void dado_que_estoy_en_la_pag_de_resultados_de_Google_IE() {

        //Capturo de ULR
        ruta = driver.getCurrentUrl();
    }

    @When("Doy clic a el enlace de Tottus nataniel Cox IE")
    public void doy_clic_a_el_enlace_de_Tottus_nataniel_Cox_IE() {

        //String NatanielCox = new String("Nataniel Cox 620");

        WebElement Opcion1 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[2]/div/div[4]/div[1]/div[1]/div/div/a[1]/div/span/div[1]/span"));
        String Lugar1 = Opcion1.getText();

        WebElement Opcion2 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[2]/div/div[4]/div[1]/div[2]/div[2]/div/a[1]/div/span/div[1]/span"));
        String Lugar2 = Opcion2.getText();

        WebElement Opcion3 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[2]/div/div[4]/div[1]/div[3]/div[2]/div/a[1]/div/span/div[1]/span"));
        String Lugar3 = Opcion3.getText();

        if (Lugar1.equals("Nataniel Cox 620")) {

            System.out.println(" Nataniel Cox es la primer opcion");
            WebElement Ingreso = driver.findElement(By.className("r-iqq4kBOJOdJc"));
            Ingreso.click();

        }
        if (Lugar2.equals("Nataniel Cox 620")) {

            System.out.println("Nataniel Cox es la segunda opcion");
            WebElement Ingreso = driver.findElement(By.className("cXedhc"));
            Ingreso.click();
        }
        if (Lugar3.equals("Nataniel Cox 620")) {

            System.out.println("Nataniel Cox es la tercera opcion");
            WebElement Ingreso = driver.findElement(By.className("r-i4_ZE2eTs_dA"));
            Ingreso.click();
        }
    }

    @Then("Me muestra en google maps la opcion para ingresar IE")
    public void me_muestra_en_google_maps_la_opcion_para_ingresar_IE() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement selectGender = wait.until(ExpectedConditions.elementToBeClickable(By.className("LrzXr")));
        WebElement fichaNataniel = driver.findElement(By.className("LrzXr"));
        String FichaNataniel = fichaNataniel.getText();

        if (FichaNataniel.equals("Nataniel Cox 620, Santiago, Región Metropolitana")) {
            System.out.println("Estoy en la ficha de google maps correcta  " + FichaNataniel);
        }

    }

    @Given("Dado que estoy en la ficha de nataniel Cox de Maps IE")
    public void dado_que_estoy_en_la_ficha_de_nataniel_Cox_de_Maps_IE() {

        //Captura URL
        ruta = driver.getCurrentUrl();

    }

    @When("Doy clic al boton sitio web IE")
    public void doy_clic_al_boton_sitio_web_IE() {

        //Doy click en el boton Sitio Web de la ficha de Google maps
        WebElement BotonSitioWeb = driver.findElement(By.className("QqG1Sd"));
        BotonSitioWeb.click();
    }

    @Then("Ingreso al portal de tottus IE")
    public void ingreso_al_portal_de_tottus_IE() {

        ruta = driver.getCurrentUrl();
        //Valido que estoy en tottus
        if (ruta.equals("https://www.tottus.cl/tottus/")) {
            System.out.println("Estoy en Tottus " + ruta);
        }
    }

    @Given("Dado que estoy en la pagina de tottus IE")
    public void dado_que_estoy_en_la_pagina_de_tottus_IE() {

        //Valido que estoy en tottus
        ruta = driver.getCurrentUrl();
    }

    @When("Doy clic al boton de recetas IE")
    public void doy_clic_al_boton_de_recetas_IE() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement BotonRecetas = wait.until(ExpectedConditions.elementToBeClickable(By.id("new_tottus_nav_cliente_recetas")));
        BotonRecetas = driver.findElement(By.id("new_tottus_nav_cliente_recetas"));
        BotonRecetas.click();
    }

    @Then("Ingreso al portal de recetas de tottus en una nueva ventana IE")
    public void ingreso_al_portal_de_recetas_de_tottus_en_una_nueva_ventana_IE() {

        driver.get("http://www.tottusrecetas.cl/");

    }

    @Given("Dado que estoy en la pagina de recetas de tottus IE")
    public void dado_que_estoy_en_la_pagina_de_recetas_de_tottus_IE() {
        //Capturo URL
        ruta = driver.getCurrentUrl();
    }

    @When("Doy clic al boton de nivel alto y voy al enlace de la receta de  rollitos de canela IE")
    public void doy_clic_al_boton_de_nivel_alto_y_voy_al_enlace_de_la_receta_de_rollitos_de_canela_IE() {

        driver.get("http://www.tottusrecetas.cl/index.php/receta/?corona-de-rollitos-de-canela_26");
    }

    @Then("Estoy en la receta Corona de rollitos de canela IE")
    public void estoy_en_la_receta_Corona_de_rollitos_de_canela_IE() {

        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

        WebElement nombrereceta = driver.findElement(By.tagName("strong"));
        String NombreReceta = nombrereceta.getText();

        if (NombreReceta.equals("CORONA DE ROLLITOS DE CANELA")) {
            System.out.println("Estoy en la receta de  " + NombreReceta);
        }
    }

    @Given("Dado que estoy en la receta de rollitos e canela IE")
    public void dado_que_estoy_en_la_receta_de_rollitos_e_canela_IE() {

        ruta = driver.getCurrentUrl();

    }

    @When("Busco si existe canela y azucar rubia IE")
    public void busco_si_existe_canela_y_azucar_rubia_IE() {
        int ExisteARubia = 0;
        int ExisteCanela = 0;
        int Canela;
        int AzucarRubia;

        List<WebElement> ingredientes = driver.findElements(By.tagName("p"));

        for (WebElement ingrediente : ingredientes) {

            ingrediente.toString();
            Canela = (ingrediente.getText()).indexOf("canela");
            AzucarRubia = (ingrediente.getText()).indexOf("azúcar rubia");

            if (Canela != -1) { ExisteCanela = 1;}

            if (AzucarRubia != -1) {  ExisteARubia = 1; }

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

    @When("Cierro Receta IE")
    public void cierro_Receta_IE() {

        driver.close();

    }

    @Then("Me quedo en la pagina principal de tottus IE")
    public void me_quedo_en_la_pagina_principal_de_tottus_IE() {


        internetExplorerOptions = new InternetExplorerOptions();
        driver = new InternetExplorerDriver();
        driver.get("https://www.tottus.cl/tottus/");
        driver.manage().window().maximize();
    }
}
