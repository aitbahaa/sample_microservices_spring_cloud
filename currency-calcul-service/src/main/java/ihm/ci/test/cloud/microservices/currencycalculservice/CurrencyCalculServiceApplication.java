package ihm.ci.test.cloud.microservices.currencycalculservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("ihm.ci.test.cloud.microservices.currencycalculservice")
@EnableDiscoveryClient
@EnableHystrix
public class CurrencyCalculServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCalculServiceApplication.class, args);
	}
	
}

