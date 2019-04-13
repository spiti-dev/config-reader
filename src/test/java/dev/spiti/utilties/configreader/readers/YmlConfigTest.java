package dev.spiti.utilties.configreader.readers;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class YmlConfigTest {

    @Test
    public void loadGlobalProps() {
        Map<String, String> properties = new YmlConfig().getConfig();
        assertThat(properties.size(), is(equalTo(3)));
        assertThat(properties.get("name"), is(equalTo("Test User")));
    }

    @Test
    public void loadAllProps() {
        Map<String, String> properties = new YmlConfig("user").getConfig();
        System.out.println(properties);
        assertThat(properties.size(), is(equalTo(15)));
        assertThat(properties.get("address.newAddress.finalAddress.zip"), is(equalTo("20000")));
        assertThat(properties.get("name.last"), is(equalTo("User")));
        assertThat(properties.get("password"),is(equalTo("secretPassword")));
        assertThat(properties.get("roles.primary"),is(equalTo("admin")));
        assertThat(properties.get("plaintextpassword"),is(equalTo("plainTextPassword")));
    }
}
