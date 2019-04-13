package dev.spiti.utilties.configreader.readers;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PropertyConfigTest {

    @Test
    public void loadGlobalProps() {
        Map<String, String>  properties = new PropertyConfig().getConfig();
        assertThat(3, is(equalTo(properties.size())));
        assertThat("global", is(equalTo(properties.get("property"))));
    }

    @Test
    public void loadMergedProps() {
        Map<String, String>  properties = new PropertyConfig("specific").getConfig();
        assertThat(properties.size(), is(equalTo(7)));
        assertThat(properties.get("property"), is(equalTo("specific")));
        assertThat(properties.get("property.password"),is(equalTo("secretPassword")));
        assertThat(properties.get("property.plaintext.password"),is(equalTo("plainTextPassword")));

    }


}
