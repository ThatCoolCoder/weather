#include <iostream>
#include <fstream>
#include <map>
#include <nlohmann/json.hpp>
#include "WeatherService.hpp"

std::map<std::string, float> compassDirectionToDegrees =
{
    {"N", 0},
    {"NNE", 22.5},
    {"NE", 45},
    {"ENE", 67.5},
    {"E", 90},
    {"ESE", 112.5},
    {"SE", 135},
    {"SSE", 157.5},
    {"S", 180},
    {"SSW", 202.5},
    {"SW", 225},
    {"WSW", 247.5},
    {"W", 270},
    {"NWN", 292.5},
    {"NW", 315},
    {"NNW", 337.5}
};
const std::string introduction = 
    "Weather service\n"
    "---------------\n"
    "\n"
    "Enter name of city to query: ";

std::string readApiKey(std::string fileName)
{
    std::ifstream file(fileName);
    std::string text;
    std::getline(file, text);
    file.close();
    return text;
}

int main()
{

    std::cout << introduction;
    std::string cityName;
    std::cin >> cityName;

    WeatherService weatherService(readApiKey("apiKey.txt"));
    nlohmann::json weather = weatherService.getCurrentWeather(cityName);
    
    std::cout << "Weather for " << cityName << ":\n" << 
        (std::string) weather["condition"]["text"] << "\n"
        "Temperature: " << weather["temp_c"] << " °C\n"
        "Wind: " << weather["wind_kph"] << " km/h at " <<
            compassDirectionToDegrees[weather["wind_dir"]] << "° \n"
        "Humidity: " << weather["humidity"] << "%\n";
}