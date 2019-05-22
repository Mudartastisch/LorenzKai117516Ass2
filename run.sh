#!/bin/sh
cd src
javac *.java

if [ $? -eq 0 ]
then
	java HeapSort ./example.txt
fi