# weather

A small weather program to learn to use Java with Maven.

## Conventions

Units used:
- Speed: km/h
- Temperature: °C
- Rainfall: mm
- Distance: km
- Pressure: millibar

Adhere to the standard Java and Maven conventions for organisation and code format. The one thing I do insist on is that braces always go on a new line.

## Structure

The program is split up into 3 subprojects (although they still share the same `pom.xml` file). `common` holds utlity code for the other two projects. `weatherApi` provides a standalone API to `weatherapi.com` and might be branched into a seperate project in the future (when it's more complete). `weatherApp` is the user-facing part of the program.

The entrypoint to the program is `weatherApp.Main`. This file just handles reading config, starting weather service and . - the main GUI application is in `weatherApp.WeatherApp`.

#### `common`

There's not much to say about this really except that it holds some utility classes. These are not specific to this project and could be easily reused or bundled as part of a library.

#### `weatherApi`

The main part of this subproject is the class `WeatherService`. It handles creating requests to `weatherapi.com` and parsing the received data. The data is then transformed into models located in `weatherApi.models` by static methods on the models themselves. The models only contain the metric data - US customary units are discarded.

#### `weatherApp`

There's not much to say here except that it handles displaying the GUI and some basic business logic (mainly in relation to managing the state of the GUI however). The widgets are hard-coded (as opposed to using a layout program) because this was my first true Java swing app and I wanted to get a feel for doing it the hard way. There are a number of classes within this project related to specific parts of the UI (such as `TopBar`) which clean and simplify the code by abstracting away details and making each class only be responsible for 5-10 widgets.

## Creating a release

Currently there's no installer generator for this, so generating a release is quite simple. Remember to update the version number in `pom.xml` and then in the utility scripts so then can find the new `.jar`s. The new number should use semantic versioning and should not include `SNAPSHOT` (this indicates that the project is heavily in development). Upload `target/weather-{VERSION}-jar-with-dependencies.jar` to GitHub releases and rename it to `weather-{VERSION}.jar`. When getting back to development after the release, change `pom.xml` to indicate that the program is once again a `SNAPSHOT`.