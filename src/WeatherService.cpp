#include "WeatherService.hpp"

WeatherService::WeatherService(std::string i_apiKey)
{
    m_apiKey = i_apiKey;
    m_httpClient.setHost(m_host);
}

nlohmann::json WeatherService::getCurrentWeather(std::string locationName)
{
    sf::Http::Request request(
        m_apiPrefix+"current.json?key="+m_apiKey+"&q="+locationName,
        sf::Http::Request::Method::Get, "");
    sf::Http::Response response = m_httpClient.sendRequest(request);
    return nlohmann::json::parse(response.getBody())["current"];
}