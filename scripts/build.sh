#!/bin/sh
# Presumes that the CWD is the root of this project
cd build

cmake .. -Wno-dev
cmake --build . --parallel $(nproc)