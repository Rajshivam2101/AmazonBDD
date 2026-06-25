package runner;

import static io.cucumber.core.options.Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("main.feature")

@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "hooks,stepDefinitions")

@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty, html:target/cucumber-reports")

@ConfigurationParameter(
        key = FILTER_TAGS_PROPERTY_NAME,
        value = "@LoginToAmazon or @Login2 or @Login3")

@ConfigurationParameter(
        key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME,
        value = "false")

public class J5Runner {

}