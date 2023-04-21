package bunga.common;

import bunga.ShipApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ShipApplication.class })
public class CucumberSpingConfiguration {}
