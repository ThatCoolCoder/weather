set(YACPM_PKGS glfw imgui glad)

if(NOT TARGET glfw)
    add_subdirectory(${CMAKE_SOURCE_DIR}/yacpkgs/glfw yacpkgs/glfw)
endif()
if(NOT TARGET imgui)
    add_subdirectory(${CMAKE_SOURCE_DIR}/yacpkgs/imgui yacpkgs/imgui)
endif()
if(NOT TARGET glad)
    add_subdirectory(${CMAKE_SOURCE_DIR}/yacpkgs/glad yacpkgs/glad)
endif()