package ihm.ci.test.cloud.microservices.currencycalculservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ihm.ci.test.cloud.microservices.currencycalculservice.controller.bean.ExchangeCalcul;
import ihm.ci.test.cloud.microservices.currencycalculservice.proxy.CurrencyExchangeServiceProxy;

@RestController
public class ExchangeCalculController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-calcul/from/{from}/to/{to}/quantity/{quantity}")
	public ExchangeCalcul returnCalculResult(@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		Map<String, String> uriVars = new HashMap<>();
		uriVars.put("from", from);
		uriVars.put("to", to);
		
		ResponseEntity<ExchangeCalcul> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", ExchangeCalcul.class, uriVars);		
		ExchangeCalcul response = responseEntity.getBody();
		return new ExchangeCalcul(response.getId(), from, to, response.getValueExchange(), quantity, quantity.multiply(response.getValueExchange()), response.getPort()); 
		
	}
	
	
	
	@GetMapping("/currency-calcul-feign/from/{from}/to/{to}/quantity/{quantity}")
	@HystrixCommand(fallbackMethod = "returnCalculResultFeignFaultTolerence")
	public ExchangeCalcul returnCalculResultFeign(@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
	
		ExchangeCalcul response = proxy.returnExchangeValue(from, to);			
		return new ExchangeCalcul(response.getId(), from, to, response.getValueExchange(), quantity, quantity.multiply(response.getValueExchange()), response.getPort()); 
		
	}
	
	
	public ExchangeCalcul returnCalculResultFeignFaultTolerence(@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		return new ExchangeCalcul();
		
	}
}
