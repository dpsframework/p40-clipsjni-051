moName=net.sf.clipsrules.jni
libName=clipsjni
libVer=6.31
tgClass=target/classes
srClass=src/main/java
ptClass=net/sf/clipsrules/jni
jarName=$libName-$libVer-osx64



echo " -------------------------------------------------------------"
echo " Compile with openjdk version "11.0.10" 2021-01-19 LTS"
echo " and create file  src/main/c/net_sf_clipsrules_jni_Environment.h"
echo " -------------------------------------------------------------"
echo " javac  $srClass/$moName/$ptClass/*java -d $tgClass/$moName   -verbose -deprecation -h src/main/c"
echo ""
echo ""
echo ""
echo " -------------------------------------------------------------"
echo " Please goes to terminal with XCode installed"
echo " -------------------------------------------------------------"
echo "  cd src/main/c/ and type:"
echo "  rm  *.o"
echo "  make -f makefile-osx64.mac"
echo "  cp libclipsjni-6.31-osx64.jnilib  ../../../."
echo ""
echo " -------------------------------------------------------------"
echo " Make Jar file"
echo " -------------------------------------------------------------"
echo " jar  -cfe $jarName.jar  $moName.Shell $tgClass/$moName/$ptClass/Shell.class  -C $tgClass/$moName net"
echo ""
echo ""
echo " -------------------------------------------------------------"
echo " Launch with: "
echo " -------------------------------------------------------------"
echo " java -jar $jarName.jar   "
echo " -------------------------------------------------------------"
echo ""

