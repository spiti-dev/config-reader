# Config Reader - Simple way to read configuration files

## Contents

*  [Key Features](#kf)
*  [Environments](#env)
*  [Limitations](#lims)
*  [Examples](#ex)

<a name="kf"></a>
## Key Features

- Reads .properties and .yml files
- Returns configs as a Map<String, String>
- Merges environment and project configs

<a name="env"></a>
## Environments

- Default config file name is project (_**project.properties**_ OR _**project.yml**_)
- Environment names can be any String value

<a name="lims"></a>
## Limitations

- Empty config files are not handled.

<a name="ex"></a>
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
