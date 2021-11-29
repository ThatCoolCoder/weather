#include "WeatherService.hpp"

WeatherService::WeatherService()
{
    m_httpClient.setHost(m_host);
}

WeatherService::