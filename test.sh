echo "Building..."
mvn clean package -U && java -cp target/weather-1.0-SNAPSHOT.jar com.thatcoolcoder.weather.Main