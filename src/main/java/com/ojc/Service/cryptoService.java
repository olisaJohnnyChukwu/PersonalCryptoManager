package com.ojc.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojc.model.crypto;

@Service
public class cryptoService implements ICryptoservice{
	
	
	@Autowired
	com.ojc.repository.cryptoRepository cryptoRepository;
	
	private static final String url="https://coinmarketcap.com/";
	@Override
	@PostConstruct
	public void scrapWeb() {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "/Users/olisajohnnychukwu/Downloads/chromedriver");
		

		System.setProperty("webdriver.chrome.driver", "/Users/olisajohnnychukwu/Downloads/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		

		driver.navigate().to(url);
		
		WebElement word=driver.findElement(By.cssSelector("#__next > div.bywovg-1.sXmSU > div.main-content > div.sc-57oli2-0.comDeo.cmc-body-wrapper > div > div > div.h7vnx2-1.bFzXgL > table"));
		
		
		List<WebElement> price=driver.findElements(By.cssSelector("td:nth-of-type(4)"));
		
		List<WebElement> name=driver.findElements(By.cssSelector("td:nth-of-type(3)"));
		
		
		//List<WebElement> marketcap=driver.findElements(By.cssSelector("td:nth-of-type(7)"));
		
		
		
		
		//List<WebElement> w2=driver.findElements(By.cssSelector(".coin-item-symbol.gGIpIK.sc-1eb5slv-0"));
		//w.stream().forEach(ww->System.out.println(ww.getText()));
		
		
		List<crypto> cryptos=cryptoRepository.findAll();
		
	
		
		
		
		
		
		for(int i=0;i<name.size();i++) {
			
			crypto crypto=new crypto();
			crypto.setName(name.get(i).getText());
			crypto.setPrice(Double.parseDouble(price.get(i).getText().substring(1).replace(",", "")));
			cryptoRepository.save(crypto);
			cryptos.add(crypto);
			
		}
		
		
		
		
		
		cryptos.stream().forEach(c->{
			cryptoRepository.updatePrice(c.getName(),c.getPrice());
		});
		
		
		
		
		
	
	}
	public List<crypto> getAll() {
		
		return cryptoRepository.findAll();
	}
	
	
	

}
