#!/bin/bash

directories=(
    "testFiles/TestCases"
    "102_Code/102_hw1"
    "102_Code/102_hw2"
    "102_Code/102_hw3"
    "102_Code/102_hw4"
    "102_Code/102_hw5"
)

mvn install

rm -rf ./output
mkdir ./output

for dir in "${directories[@]}"; do
    for sub in $(find "$dir" -maxdepth 1 -type d); do

        if [[ "$dir" != "$sub" ]]; then

            echo "Checking: $sub"
            mkdir -p "./output/$dir"
            mvn exec:java -Dexec.args="$sub" > ./output/${sub}.out

        fi

    done
done