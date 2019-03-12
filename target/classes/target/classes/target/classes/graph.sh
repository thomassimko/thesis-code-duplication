#!/bin/bash

dot -Tpng cfg.gv -o cfg.png

for filename in ./pdg/source/*.gv; do
    name=$(basename "$filename" .gv)
    dot -Tpng "$filename" -o ./pdg/images/"$name".png
done
