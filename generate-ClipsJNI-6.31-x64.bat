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
echo. Compile with  Java JDK-17.0.3.1 (2022)
echo. and create file  src/main/c/net_sf_clipsrules_jni_Environment.h
echo. -------------------------------------------------------------
echo. javac -p %moName% %srClass%/%moName%/module-info.java %srClass%/%moName%/%ptClass%/*java -d %tgClass%/%moName%   -verbose -deprecation -h src/main/c
echo.
echo. Without module: 
echo. javac %srClass%/%moName%/%ptClass%/*java -d %tgClass%/%moName%   -verbose -deprecation -h src/main/c
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
echo. jar  -cfe %jarName%.jar  %moName%.Shell %tgClass%/%moName%/%ptClass%/Shell.class %tgClass%/%moName%/module-info.class -C %tgClass%/%moName% net
echo.
echo. Without module: 
echo. jar  -cfe %jarName%.jar  %moName%.Shell %tgClass%/%moName%/%ptClass%/Shell.class -C %tgClass%/%moName% net
echo.
echo. -------------------------------------------------------------
echo. Launch with: 
echo. -------------------------------------------------------------
echo. java -p %jarName%.jar    -m %moName%/%moName%.Shell
echo. java -jar %jarName%.jar    net.sf.clipsrules.jni.Shell
echo. java  %moName%.Shell
echo. -------------------------------------------------------------
echo.

