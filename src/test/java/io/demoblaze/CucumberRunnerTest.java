package io.demoblaze;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"java/io/demoblaze/steps"},
        tags = "@regression",
        plugin = {"pretty",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        })
public class CucumberRunnerTest {

}
