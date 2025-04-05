package starter;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "starter.stepdefinitions" // 🔁 Busqueda de los steps definitions
)
@ConfigurationParameter(
        key = FILTER_TAGS_PROPERTY_NAME,
        value = "@actual"
)
public class CucumberTestSuite {
}
