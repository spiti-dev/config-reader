# Config Reader - Simple way to read configuration files

## Key Features

- Reads .properties and .yml files
- Returns configs as a Map<String, String>
- Merges environment and project configs

## Environments

- Default config file name is project (_**project.properties**_ OR _**project.yml**_)
- Environment names can be any String value

## Limitations

- Empty config files are not handled.

## Examples

#### Read _YML_ files

```
Map<String, String> properties = new YmlConfig("dev").getConfig();
```
  - Reads `dev.yml` and `project.yml`
  - Merges both files - environment property is considered to return when duplicate key exists
  - Returns the merged configuration as a `Map<String, String>`

```
Map<String, String> properties = new YmlConfig().getConfig();
```
  - Reads and returns `project.yml`

#### Read _PROPERTIES_ files

```
Map<String, String> properties = new PropertyConfig("dev").getConfig();
```
  - Reads `dev.properties` and `project.properties`
  - Merges both files - environment property is considered to return when duplicate key exists
  - Returns the merged configuration as a `Map<String, String>`

```
Map<String, String> properties = new PropertyConfig().getConfig();
```
  - Reads and returns `project.properties`  
