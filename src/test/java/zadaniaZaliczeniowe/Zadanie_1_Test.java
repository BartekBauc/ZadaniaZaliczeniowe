package zadaniaZaliczeniowe;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/zadanie1.feature",
        plugin = {"pretty", "html:out"})

public class Zadanie_1_Test {
}
