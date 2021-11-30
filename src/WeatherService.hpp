#include <iostream>
#include <SFML/Network.hpp>
#include <nlohmann/json.hpp>

class WeatherService
{
public:
    WeatherService(std::string i_apiKey);

    nlohmann::json getCurrentWeather(std::string locationName);
    
private:
    const std::string m_host = "http://api.weatherapi.com/";
    const std::string m_apiPrefix = "v1/";
    sf::Http m_httpClient;
    std::string m_apiKey;
};