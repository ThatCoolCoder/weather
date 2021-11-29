#include <SFML/Network.hpp>

class WeatherService
{
public:
    WeatherService();
    
private:
    const std::string m_host = "https://whatwebsite.com";
    const std::string m_apiPrefix = "/api/v1/"
    sf::Http m_httpClient;
};