@echo off
::  Module_Name
set moName=net.sf.clipsrules.jni
set libName=clipsjni
set libVer=6.31
set tgClass=target/classes
set srClass=src/main/java
set ptClass=net/sf/clipsrules/jni
set jarName=%libName%-%libVer%-x64



echo. -------------------------------------------------------------
echo. Compile with  openjdk version "11.0.14" 2022-01-18 LTS
echo. and create file  src/main/c/net_sf_clipsrules_jni_Environment.h
echo. -------------------------------------------------------------
echo. javac %srClass%/%moName%/%ptClass%/*java -d %tgClass%/%moName%   -verbose -deprecation -h src/main/c
echo.
echo.
echo.
echo. -------------------------------------------------------------
echo. Please goes to Native Tools VS2022 x64
echo. -------------------------------------------------------------
echo   cd src/main/c/ and type:
echo.  del *.obj
echo.  nmake -f makefile-x64.win CLIPSJNI.dll
echo.  copy *.dll ..\..\..\.
echo.
echo.
echo. -------------------------------------------------------------
echo. Make Jar file
echo. -------------------------------------------------------------
echo. jar  -cfe %jarName%.jar  %moName%.Shell %tgClass%/%moName%/%ptClass%/Shell.class -C %tgClass%/%moName% net
echo.
echo. -------------------------------------------------------------
echo. Launch with: 
echo. -------------------------------------------------------------
echo. java -jar %jarName%.jar    
echo. -------------------------------------------------------------
echo.

