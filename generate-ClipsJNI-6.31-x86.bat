@echo off
::  clipsjni-6.31-x32.jar
set moName=net.sf.clipsrules.jni
set libName=clipsjni
set libVer=6.31
set tgClass=target/classes
set srClass=src/main/java
set ptClass=net/sf/clipsrules/jni
set jarName=%libName%-%libVer%-x86



echo. -------------------------------------------------------------
echo. Compile with  Java JDK 1.8.0_333  (2022)
echo. and create file  src/main/c/net_sf_clipsrules_jni_Environment.h
echo. -------------------------------------------------------------
echo. javac  %srClass%/%moName%/%ptClass%/*java -d %tgClass%  -verbose -deprecation  -h src/main/c
echo.
echo.
echo. -------------------------------------------------------------
echo. Please goes to Native Cross Tools VS2022 x64-x86
echo. -------------------------------------------------------------
echo   cd src/main/c/ and type:
echo.  del *.obj
echo.  nmake -f makefile-x86.win CLIPSJNI.dll
echo.  copy *.dll ..\..\..\.
echo.
echo.
echo.
echo. -------------------------------------------------------------
echo. Make Jar file
echo. -------------------------------------------------------------
echo. jar  -cfe %jarName%.jar  %moName%.Shell %tgClass%/%ptClass%/Shell.class  -C %tgClass% net
echo.
echo.
echo. -------------------------------------------------------------
echo. Launch with: 
echo. -------------------------------------------------------------
echo. java -jar %jarName%.jar   net.sf.clipsrules.jni.Shell    or simple...
echo. java net.sf.clipsrules.jni.Shell
echo. -------------------------------------------------------------


