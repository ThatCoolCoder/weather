cmake_minimum_required(VERSION 3.12)

project(weather)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED True)

file(GLOB_RECURSE SOURCES "src/*.cpp")

if(NOT EXISTS "${CMAKE_CURRENT_BINARY_DIR}/yacpm.cmake")
    file(DOWNLOAD "https://github.com/Calbabreaker/yacpm/raw/v2/yacpm.cmake" "${CMAKE_CURRENT_BINARY_DIR}/yacpm.cmake")
endif()

include(${CMAKE_CURRENT_BINARY_DIR}/yacpm.cmake)
yacpm_use_extended()

add_executable(weather ${SOURCES})
target_link_libraries(${PROJECT_NAME} ${YACPM_PKGS})
