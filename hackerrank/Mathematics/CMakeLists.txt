cmake_minimum_required(VERSION 3.6)
project(Mathematics)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES)
add_executable(math Fundamentals/main.cpp ${SOURCE_FILES})