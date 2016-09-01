package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = false,
        glue = {"adapters"},
        features = {"src/test/java/features/"},
        format = {"pretty", "json:target/cucumber/cucumber.json"}
)
public class Demo_IT
{

}
