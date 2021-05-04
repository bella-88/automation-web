package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "C:\\Bella\\project-auto\\automation-web\\src\\test\\java\\features",
  format = {"json:target/cucumber.json","html:target"},
  glue = "stepDefinitions",
  monochrome = true,
  plugin = {"pretty:target/cucumber-report/report.html", "json:target/cucmber-report.json"},
  snippets = SnippetType.CAMELCASE,
  tags = {"@Login"}
)
public class TestRunner {
}
