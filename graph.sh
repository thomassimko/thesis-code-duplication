#!/bin/bash

dot -Tpng cfg.gv -o cfg.png
for filename in `find ./pdg/source -name "*.gv"`; do
    prefix="./pdg/source/"
    newName=${filename#"$prefix"}
    newName=${newName%".gv"}
    base="./pdg/images/${newName}"
    newDir=${base%/*}
    mkdir -p "$newDir"
    dot -Tpng "$filename" -o ./pdg/images/"$newName".png
done
