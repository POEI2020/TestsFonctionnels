package com.projet.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SeleniumTest extends SpringBootServletInitializer {

	public static void main(String[] args) throws InterruptedException {
		
		SpringApplication.run(SeleniumTest.class);
		
		// Afficher page d'accueil, récupère titre, vérifie url, etc
		SeleniumBrowserTest();
		// Afficher partie "Features" de la page d'accueil en cliquant sur bouton "Plus d'infos"
		//SeleniumFeaturesTest();
		// Afficher les pages du site en cliquant sur les différents boutons du menu de navigation
		//SeleniumNavigationTest();
		// Test de saisie d'un élément du formulaire et redirection sur la page "My Places" avec liste correctement remplie
		//SeleniumFormulaireTest();
		// Test de mise à jour d'un élément de la liste avec redirection sur formulaire
		//SeleniumListUpdateTest();
		
	}

	
	
	// Affichage de la page d'accueil du site et récupération du titre, comparaison url, etc
	public static void SeleniumBrowserTest() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Test affichage page d'accueil
		String url = "https://secure-crag-94496.herokuapp.com/";
		driver.get(url);

		// Récupérer titre de la page
		String title = driver.getTitle();
		int titleLength = title.length();
		System.out.println("Titre page = " + title);
		System.out.println("Longueur titre : " + titleLength);

		// vérifier exactitude l'URL
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.equals(url)) {
			System.out.println("Succès : URL correct");
		} else {
			System.out.println("Echec : URL incorrect");
			System.out.println("URL = " + actualUrl);
			System.out.println("URL attendue : " + url);
		}

		// Longueur de la page
		String pageSource = driver.getPageSource();
		int pageSourceLength = pageSource.length();
		System.out.println("Page source : " + pageSource);
		System.out.println("Longueur totale page source = " + pageSourceLength);

		driver.close();
	}
	
	
	
	// Trouver et cliquer sur bouton "Plus d'infos" pour être envoyé sur partie "features" de la page d'accueil
	public static void SeleniumFeaturesTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String urlAccueil = "https://secure-crag-94496.herokuapp.com/";
		driver.get(urlAccueil);
		Thread.sleep(2000);
		
		// Clic sur bouton "Plus d'infos", vérifier URL features
		driver.findElement(By.xpath("/html/body/header/div[2]/div")).click();
		String actualFeatureUrl = driver.getCurrentUrl();
		String expectFeatureUrl = "https://secure-crag-94496.herokuapp.com/#features";
		if (actualFeatureUrl.equals(expectFeatureUrl)) {
			System.out.println("Succès : URL correct");
			System.out.println("URL = " + actualFeatureUrl);
		} else {
			System.out.println("Echec : URL incorrect");
			System.out.println("URL = " + actualFeatureUrl);
			System.out.println("URL attendue : " + expectFeatureUrl);
		}
		Thread.sleep(2000);
		
		// clic sur titre header, vérification url
		driver.findElement(By.xpath("/html/body/header/nav/div[1]/h1/a")).click();
		Thread.sleep(2000);
		actualFeatureUrl = driver.getCurrentUrl();
		expectFeatureUrl = "https://secure-crag-94496.herokuapp.com/index.html";
		if (actualFeatureUrl.equals(expectFeatureUrl)) {
			System.out.println("Succès : URL correct");
			System.out.println("URL = " + actualFeatureUrl);
		} else {
			System.out.println("Echec : URL incorrect");
			System.out.println("URL = " + actualFeatureUrl);
			System.out.println("URL attendue : " + expectFeatureUrl);
		}
		Thread.sleep(2000);
		
		// Clic sur bouton "Plus d'infos", vérifier URL features
		driver.findElement(By.xpath("/html/body/header/div[2]/div")).click();
		actualFeatureUrl = driver.getCurrentUrl();
		expectFeatureUrl = "https://secure-crag-94496.herokuapp.com/index.html#features";
		if (actualFeatureUrl.equals(expectFeatureUrl)) {
			System.out.println("Succès : URL correct");
			System.out.println("URL = " + actualFeatureUrl);
		} else {
			System.out.println("Echec : URL incorrect");
			System.out.println("URL = " + actualFeatureUrl);
			System.out.println("URL attendue : " + expectFeatureUrl);
		}
		Thread.sleep(2000);
		
		driver.close();
	}
	
	
	
	// Test de navigation entre les pages
	public static void SeleniumNavigationTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String urlAccueil = "https://secure-crag-94496.herokuapp.com/";
		driver.get(urlAccueil);
		Thread.sleep(2000);
		
		// Clic sur bouton "My Places", vérification url
		driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li[2]/a")).click();
		String actualFeatureUrl = driver.getCurrentUrl();
		String expectFeatureUrl = "https://secure-crag-94496.herokuapp.com/MyPlacesToVisit.html";
		if (actualFeatureUrl.equals(expectFeatureUrl)) {
			System.out.println("Succès : URL correct");
			System.out.println("URL = " + actualFeatureUrl);
		} else {
			System.out.println("Echec : URL incorrect");
			System.out.println("URL = " + actualFeatureUrl);
			System.out.println("URL attendue : " + expectFeatureUrl);
		}
		Thread.sleep(2000);
		
		// clic sur le logo pour revenir à la page d'accueil index
		driver.findElement(By.xpath("/html/body/header/nav/div[1]/a/img")).click();
		Thread.sleep(2000);
		actualFeatureUrl = driver.getCurrentUrl();
		expectFeatureUrl = "https://secure-crag-94496.herokuapp.com/index.html";
		if (actualFeatureUrl.equals(expectFeatureUrl)) {
			System.out.println("Succès : URL correct");
			System.out.println("URL = " + actualFeatureUrl);
		} else {
			System.out.println("Echec : URL incorrect");
			System.out.println("URL = " + actualFeatureUrl);
			System.out.println("URL attendue : " + expectFeatureUrl);
		}
		Thread.sleep(2000);
		
		// clic la page du formulaire "New Places"
		driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li[3]/a")).click();
		Thread.sleep(2000);
		actualFeatureUrl = driver.getCurrentUrl();
		expectFeatureUrl = "https://secure-crag-94496.herokuapp.com/PlacesToVisitItemForm.html";
		if (actualFeatureUrl.equals(expectFeatureUrl)) {
			System.out.println("Succès : URL correct");
			System.out.println("URL = " + actualFeatureUrl);
		} else {
			System.out.println("Echec : URL incorrect");
			System.out.println("URL = " + actualFeatureUrl);
			System.out.println("URL attendue : " + expectFeatureUrl);
		}
		Thread.sleep(2000);
		
		// clic sur le bouton "Home" pour revenir à la page d'accueil index
		driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		actualFeatureUrl = driver.getCurrentUrl();
		expectFeatureUrl = "https://secure-crag-94496.herokuapp.com/index.html";
		if (actualFeatureUrl.equals(expectFeatureUrl)) {
			System.out.println("Succès : URL correct");
			System.out.println("URL = " + actualFeatureUrl);
		} else {
			System.out.println("Echec : URL incorrect");
			System.out.println("URL = " + actualFeatureUrl);
			System.out.println("URL attendue : " + expectFeatureUrl);
		}
		Thread.sleep(2000);
		
		driver.close();
	}
	
	
	
	// Test de saisie d'un élément du formulaire et redirection sur la page "My Places" avec liste correctement remplie
	public static void SeleniumFormulaireTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String urlAccueil = "https://secure-crag-94496.herokuapp.com/PlacesToVisitItemForm.html";
		driver.get(urlAccueil);
		Thread.sleep(3000);
		
		// Sélection d'un lieu de la liste déroulante
		List<WebElement> formLieu = driver.findElements(By.xpath("//select[@id='departement-select']//option"));
		formLieu.get(9).click();
		System.out.println("Lieu = " + formLieu);
		//List<WebElement> formLieu3 = driver.findElements(By.xpath("/select/option[normalize-space(text())='68-HAUT-RHIN - Eguisheim']"));
		//System.out.println("Lieu = " + formLieu3);
		Thread.sleep(2000);
		
		// Sélection d'un montant pour le budget
		WebElement formBudget = driver.findElement(By.id("price-estimated"));
		formBudget.sendKeys("100");
		Thread.sleep(2000);
		
		// Sélection d'une période/date de la liste déroulante
		List<WebElement> formDate = driver.findElements(By.xpath("//select[@id='priority']//option"));
		formDate.get(2).click();
		System.out.println("Lieu = " + formDate);
		Thread.sleep(2000);
		
		// Clic sur le bouton "Enregistrer dans mes futures destinations", vérification URL
		driver.findElement(By.xpath("/html/body/section/div/form/fieldset/div[2]/button")).click();
		Thread.sleep(2000);
		String actualListUrl = driver.getCurrentUrl();
		String expectedListUrl = "https://secure-crag-94496.herokuapp.com/MyPlacesToVisit.html";
		if (actualListUrl.equals(expectedListUrl)) {
			System.out.println("Succès : URL correct");
			System.out.println("URL = " + actualListUrl);
		} else {
			System.out.println("Echec : URL incorrect");
			System.out.println("URL = " + actualListUrl);
			System.out.println("URL attendue : " + expectedListUrl);
		}
		Thread.sleep(2000);
		
		// Vérifier que le lieu enregistré est le même que celui qui a été saisi
		// WebElement titreLieuList = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[1]"));
		
		driver.close();
	}
	
	
	
	// Test de mise à jour d'un élément de la liste en cliquant sur le bouton Update
	public static void SeleniumListUpdateTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String urlList = "https://secure-crag-94496.herokuapp.com/MyPlacesToVisit.html";
		driver.get(urlList);
		Thread.sleep(2000);
		
		// Clic sur bouton "Update, vérification url de renvoi
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[5]/a")).click();
		String actualFormUrl = driver.getCurrentUrl();
		String expectFormUrl = "https://secure-crag-94496.herokuapp.com/PlacesToVisitItemForm.html?id=0";
		if (actualFormUrl.equals(expectFormUrl)) {
			System.out.println("Succès : URL correct");
			System.out.println("URL = " + actualFormUrl);
		} else {
			System.out.println("Echec : URL incorrect");
			System.out.println("URL = " + actualFormUrl);
			System.out.println("URL attendue : " + expectFormUrl);
		}
		Thread.sleep(2000);
		
		// Sélection du même lieu de la liste déroulante
		List<WebElement> formLieu = driver.findElements(By.xpath("//select[@id='departement-select']//option"));
		formLieu.get(9).click();
		System.out.println("Lieu = " + formLieu);
		Thread.sleep(2000);
		
		// Décider d'y aller dans les 7 jours
		List<WebElement> formDate = driver.findElements(By.xpath("//select[@id='priority']//option"));
		formDate.get(1).click();
		System.out.println("Lieu = " + formDate);
		Thread.sleep(2000);
		
		// Ajouter un commentaire
		WebElement formComments = driver.findElement(By.id("commentaire"));
		formComments.sendKeys("J'ai hâte");
		Thread.sleep(2000);
		
		// Clic sur le bouton "Enregistrer dans mes futures destinations", vérification URL
		driver.findElement(By.xpath("/html/body/section/div/form/fieldset/div[2]/button")).click();
		Thread.sleep(2000);
		String actualListUrl = driver.getCurrentUrl();
		String expectedListUrl = "https://secure-crag-94496.herokuapp.com/MyPlacesToVisit.html";
		if (actualListUrl.equals(expectedListUrl)) {
			System.out.println("Succès : URL correct");
			System.out.println("URL = " + actualListUrl);
		} else {
			System.out.println("Echec : URL incorrect");
			System.out.println("URL = " + actualListUrl);
			System.out.println("URL attendue : " + expectedListUrl);
		}
		Thread.sleep(2000);
		
		driver.close();
	}
	
}