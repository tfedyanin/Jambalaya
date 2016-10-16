cmake_minimum_required(VERSION 3.6)
project(native_part)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -Wall -D_JNI_IMPLEMENTATION_ -Wl,--kill-at -Wl,--add-stdcall-alias ")
find_package(JNI)

if (JNI_FOUND)
    message(STATUS "JNI_INCLUDE_DIRS=${JNI_INCLUDE_DIRS}")
    message(STATUS "JNI_LIBRARIES=${JNI_LIBRARIES}")
endif ()


set(SOURCE_FILES jambalaya_jni_Main.c)
include_directories(${JNI_INCLUDE_DIRS})

ADD_LIBRARY(testlib SHARED jambalaya_jni_Main.c)

get_filename_component(TESTLIB_OUTPUT_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../java_part/libs/native ABSOLUTE)
message(STATUS "TESTLIB_OUTPUT_DIR=${TESTLIB_OUTPUT_DIR}")


set_target_properties(testlib
        PROPERTIES
        ARCHIVE_OUTPUT_DIRECTORY ${TESTLIB_OUTPUT_DIR}
        LIBRARY_OUTPUT_DIRECTORY ${TESTLIB_OUTPUT_DIR}
        RUNTIME_OUTPUT_DIRECTORY ${TESTLIB_OUTPUT_DIR}
        )