/** **********************************************************
 * Principal Programmer(s):
 *      Gary D. Riley
 *
 *
 * Contributing Programmer(s):
 *      FJ Aguayo, Ph.D. 
 *************************************************************
 *
 *  <This repository contains a fork of CLIPSJNI library 
 *  to provide a JKD-17 LTS (2022-2029) compatibility for 
 *  CLIPS, a Tool for Building Expert Systems.>
 *  
 *  Copyright (C) <2022>  <FJ Aguayo>
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *  USA
 *************************************************************
 */

package net.sf.clipsrules.jni;

import java.io.InputStream;
import java.net.URISyntaxException;


/**
 * Environment CLIPS-6.31 revised.
 * @author Riley, G  (2019) version-0.51.
 * @author FJ Aguayo (2022/07)
 * @version 0.51-PsAgents-2022
 */
public class Environment {
     

     public static final String FACTS             = "facts";
     public static final String RULES             = "rules";
     public static final String DEFFUNCTIONS      = "deffunctions";
     public static final String COMPILATIONS      = "compilations";
     public static final String INSTANCES         = "instances";
     public static final String SLOTS             = "slots";
     public static final String ACTIVATIONS       = "activations";
     public static final String STATISTICS        = "statistics";
     public static final String FOCUS             = "focus";
     public static final String GENERIC_FUNCTIONS = "generic-functions";
     public static final String METHODS           = "methods";
     public static final String GLOBALS           = "globals";
     public static final String MESSAGES          = "messages";
     public static final String MESSAGE_HANDLERS  = "message-handlers";


     private static final String CLIPSJNI_NAME    = "clipsjni";  // Lock 
     private static final String CLIPS_VERSION    = "6.31";      // Lock 
     private static final String CLIPSJNI_VERSION = "0.51";      // Hard-coded



     private long pointerToEnvironment;
     private static final int CLIPSJNI_LOAD            = 0;
     private static final int CLIPSJNI_LOADLIBRARY     = 1;
     private static final int CLIPSJNI_JARFILE         = 2;
     private static final int CLIPSJNI_JARNAME         = 3;
     private static final int CLIPSJNI_JARDIR          = 4;

     private static final String INFO_NOT_ALLOWED_ES_ES = "\n" +
             "Por favor, utilice esta Shell del objeto Environment de CLIPS con la máxima precaución. \n"
             + "Esta forma de acceder a la instancia de CLIPS, permite acceder a la Memoria de Trabajo, \n"
             + "la Agenda y la Memoria Activa de la misma instancia controladas por un Agente-PS en tiempo \n"
             + "de ejecución sobre JADE. Usted, puede seguir empleando esta consola de CLIPS mediante: \n\n"
             + "java net.sf.clipsrules.jni.Shell para una mayor seguridad, generando una instancia aislada \n"
             + "del motor CLIPS dentro de un hilo interno de ejecución.";
           
           private static final String INFO_NOT_ALLOWED = "\n" +
             " NOTE: Please use this shell of the CLIPS Environment object with the utmost caution.  \n"
             + " This way of accessing the CLIPS instance allows access to the Working Memory, \n"
             + " Agenda and Active Memory of the same instance controlled by a PS-Agent at runtime \n"
             + " on JADE. You can still use this CLIPS console via: java net.sf.clipsrules.jni.Shell \n"
             + " for greater security, generating an isolated instance of the CLIPS engine within \n"
             + " an internal thread of execution.\n"
             + " For instance:\n\n"
             + " $ java  net.sf.clipsrules.jni.Shell                               \n"
             + " $ java -jar clipsjni-6.31-x64.jar net.sf.clipsrules.jni.Shell     \n\n"
             + " Or with Java Module System call mode with:\n\n"
             + " $ java -p clipsjni-6.31-x64.jar -m net.sf.clipsrules.jni/net.sf.clipsrules.jni.Shell"
             + " \n\n Enjoy !";

          
     /**
      * @see http://lopica.sourceforge.net/os.html  for complete list of architectures / OS Names
      * @return Native Library name with CLIPS-Version and JVM-OS architecture.
      * @throws URISyntaxException 
      */
     public static String getNativeClipsJNIname(int mode) {
          String arch  = System.getProperties().getProperty("os.arch");
          String os    = System.getProperties().getProperty("os.name");
          
          String nativeSufj = ""; 
          String nativeArch = ""; 
          String nativeExt  = "";
          
          
          
          if ( arch.contains("amd86")  && os.contains("Linux"))   { 
             nativeSufj  = "lib";
             nativeExt   = ".so";
             nativeArch  = "amd86";
          }
          
          
          if ( arch.contains("amd64")  && os.contains("Linux"))   { 
             nativeSufj  = "lib";
             nativeExt   = ".so";
             nativeArch  = "amd64";
          }
          
          
          if ( arch.contains("86")     && os.contains("Windows")) { 
             nativeSufj  = "";
             nativeExt   = ".dll";
             nativeArch = "x86";
          }
          
          
          if ( arch.contains("64")     && os.contains("Windows")) { 
             nativeSufj  = "";
             nativeExt   = ".dll";
             nativeArch  = "x64";
          }
          
          
          if ( os.contains("Mac"))     { 
             nativeSufj = "lib";
             nativeExt  = ".jnilib";
             nativeArch = "osx64";
          }
          
          
          if ( arch.contains("arm")  &&   os.contains("Linux"))   { 
             nativeSufj  = "lib";
             nativeExt   = ".so";
             nativeArch  = "arm64";
          }
          
          
          
          String jarFile = net.sf.clipsrules.jni.Environment.class.getProtectionDomain().getCodeSource().getLocation().getPath();
          String jarName = CLIPSJNI_NAME + "-" + CLIPS_VERSION + "-" + nativeArch + ".jar";
          String jarDir  = jarFile.split(jarName)[0];
          // Debuggin:
          //        System.out.println("jarFile: " + jarFile);
          //        System.out.println("jarName: " + jarName);
          //        System.out.println("jarDir:  " + jarDir);


          String loadLibraryName = "clipsjni-" + CLIPS_VERSION + "-" + nativeArch;
          String loadLibraryPath = jarDir + nativeSufj + loadLibraryName + nativeExt;
          // The poor-man debugger:
          // This produces:
          // clipsjni-6.31-amd32.jar -->  libclipsjni-6.31-amd32.so
          // clipsjni-6.31-amd64.jar -->  libclipsjni-6.31-amd64.so
          // clipsjni-6.31-x86.jar   -->  clipsjni-6.31-x86.dll
          // clipsjni-6.31-x64.jar   -->  clipsjni-6.31-x64.dll
          // clipsjni-6.31-osx64.jar -->  libclipsjni-6.31-osx64.jnilib
          // clipsjni-6.31-arm64.jar -->  libclipsjni-6.31-arm64.so
          // 
          // System.out.println("loadLibraryPath: " + loadLibraryPath);
          
          
          
          switch (mode) {
          case CLIPSJNI_LOAD:          // 0 By default:
               return( loadLibraryPath ); 
               
          case CLIPSJNI_LOADLIBRARY:   // 1
               return( loadLibraryName );
               
          case CLIPSJNI_JARFILE:       // 2
               return( jarFile );   
               
          case CLIPSJNI_JARNAME:       // 3
               return( jarName );
               
          case CLIPSJNI_JARDIR:        // 4
               return( jarDir );

          default:
               // It finds Native Library at the same path of JAR file.
               return( loadLibraryPath ); 

          }
          
     }    
     

     static {
          
          int modeLoad = CLIPSJNI_LOAD; // by default
          
          // When Java is launched with:  java -Dmode.clipsjni= 1 or 0
          String javMode = System.getProperty("mode.clipsjni", "0");
          
          // When OS-Env contains variable: MODE_CLIPSJNI = 0/1
          String envMode = System.getenv("MODE_CLIPSJNI");
          if ( System.getenv("MODE_CLIPSJNI") == null ) {  envMode = "0";  } 
          if ( javMode.equals("1") ||  envMode.equals("1") ) {    modeLoad = CLIPSJNI_LOADLIBRARY;     }

          // System.out.println("mode.clipsjni: "+ javMode);
          // System.out.println("MODE_CLIPSJNI: "+ envMode);
          // System.out.println("modeLoad: "+ modeLoad);
          
          
          // This is the java.lang.UnsatisfiedLinkError connection-moment:
          // CLIPSJNI_LOAD        : uses complete name of Library with the full path of .JAR file.
          // CLIPSJNI_LOADLIBRARY : uses OS PATH environment and simple name of Library.
          if (modeLoad == CLIPSJNI_LOAD) {
               System.load(       getNativeClipsJNIname(CLIPSJNI_LOAD       ));
          } else  {
               System.loadLibrary(getNativeClipsJNIname(CLIPSJNI_LOADLIBRARY));  
          }
     }



     /**
      * CLIPS Java Native Methods and Fields.
      * 
      */
     private native void           destroyEnvironment(long env);
     private native void           commandLoop(long env);
     private static native String  getCLIPSVersion();
     private native long           createEnvironment();
     private native void           clear(long env);
     private native void           reset(long env);    
     private native void           loadFromString(long env, String loadString);
     private native void           load(long env, String filename);
     private native boolean        loadFacts(long env, String filename);
     private native boolean        watch(long env, String watchItem);
     private native boolean        unwatch(long env, String watchItem);
     private native long           run(long env, long runLimit);
     private native boolean        build(long env, String buildStr);
     private native String         getInputBuffer(long env);
     private native void           setInputBuffer(long env, String theString);
     private native long           getInputBufferCount(long env);
     private native void           incrementInstanceCount(Environment javaEnv, long env, long instance);
     private native void           decrementInstanceCount(Environment javaEnv, long env, long instance);
     private native void           incrementFactCount(Environment javaEnv, long env, long fact);
     private native void           decrementFactCount(Environment javaEnv, long env, long fact);
     private native long           setInputBufferCount(long env, long theValue);
     private native void           expandInputBuffer(long env, char theChar);
     private native void           appendInputBuffer(long env, String theString);
     private native boolean        inputBufferContainsCommand(long env);
     private native void           commandLoopOnceThenBatch(long env);
     private native void           printBanner(long env);
     private native void           printPrompt(long env);
     private native boolean        addRouter(long env, String routerName, int priority, Router theRouter);




     // NOTE: before this Patch, they were static!
     private native long                     factIndex(Environment javaEnv, long env, long fact);
     private native PrimitiveValue           getFactSlot(Environment javaEnv, long env, long fact, String slotName);
     private native String                   getInstanceName(Environment javaEnv, long env, long instance);
     private native PrimitiveValue           directGetSlot(Environment javaEnv, long env, long instance, String slotName);

     
     // NOTE: before this Patch, they had package visibility !
     private native FactAddressValue         assertString(long env, String factStr);
     private native PrimitiveValue           eval(long env, String evalStr);
     private native InstanceAddressValue     makeInstance(long env, String instanceStr);
     
     
     
     
     /**
      * Environment declares Library and natives methods of
      * CLIPS version 6.31, from Java (JDK-17 or ++).
      * 
      */
     public Environment() {
          super();
          pointerToEnvironment = createEnvironment();
     }
     
     
     
     /**
      * @return CLIPSJNI_VERSION
      */
     public static String getCLIPSJNIVersion() {
          return CLIPSJNI_VERSION;
     }
     
     
     
     /**
      * @return Two lines.
      */
     public static String getVersion() {
          return    " (clipsjni version: " + getCLIPSJNIVersion() + ")\n"
                    + " (CLIPS    version: " + getCLIPSVersion()      + ")";
     }
     
     
     
     /**
      * @return long 
      */
     public long getEnvironmentAddress() {
          return pointerToEnvironment;
     }
     
     
     
     public Environment getEnvironmentObject() {
          return this;
     }
     
     
     
     public void clear() {
          clear(pointerToEnvironment);
     }
     
     
     
     public void reset() {
          reset(pointerToEnvironment);
     }
     
     
     
     private static String convertStreamToString(java.io.InputStream is) {
          try (java.util.Scanner s = new java.util.Scanner(is, "UTF-8").useDelimiter("\\A")) {
               return s.hasNext() ? s.next() : "";
          }
     }
     
     
     
     public void loadFromResource(String resourceFile) {
          InputStream input = getClass().getResourceAsStream(resourceFile);
          if (input == null)
               return;
          loadFromString(pointerToEnvironment, convertStreamToString(input));
     }
     
     
     
     public void loadFromString(String loadString) {
          loadFromString(pointerToEnvironment, loadString);
     }
     
     
     
     public void load(String filename) {
          load(pointerToEnvironment, filename);
     }
     
     
     
     public boolean loadFacts(String filename) {
          return loadFacts(pointerToEnvironment, filename);
     }
     
     
     
     public boolean watch(String watchItem) {
          return watch(pointerToEnvironment, watchItem);
     }
     
     
     
     public boolean unwatch(String watchItem) {
          return unwatch(pointerToEnvironment, watchItem);
     }
     
     
     
     public long run(long runLimit) {
          return run(pointerToEnvironment, runLimit);
     }
     
     
     
     public long run() {
          return run(pointerToEnvironment, -1);
     }
     
     
     
     public PrimitiveValue eval(String evalStr) {
          return eval(pointerToEnvironment, evalStr);
     }
     
     
     
     public boolean build(String buildStr) {
          return build(pointerToEnvironment, buildStr);
     }
     
     
     
     public FactAddressValue assertString(String factStr) {
          return assertString(pointerToEnvironment, factStr);
     }
     
     
     
     public long factIndex(FactAddressValue theFact) {
          return factIndex(theFact.getEnvironment(), theFact.getEnvironment().getEnvironmentAddress(),
                    theFact.getFactAddress());
     }
     
     
     
     public PrimitiveValue getFactSlot(FactAddressValue theFact, String slotName) {
          return getFactSlot(theFact.getEnvironment(), theFact.getEnvironment().getEnvironmentAddress(),
                    theFact.getFactAddress(), slotName);
     }
     
     
     
     public InstanceAddressValue makeInstance(String instanceStr) {
          return makeInstance(pointerToEnvironment, instanceStr);
     }
     
     
     
     public String getInstanceName(InstanceAddressValue theInstance) {
          return getInstanceName(theInstance.getEnvironment(), theInstance.getEnvironment().getEnvironmentAddress(),
                    theInstance.getInstanceAddress());
     }
     
     
     
     
     public PrimitiveValue directGetSlot(InstanceAddressValue theInstance, String slotName) {
          return directGetSlot(theInstance.getEnvironment(), theInstance.getEnvironment().getEnvironmentAddress(),
                    theInstance.getInstanceAddress(), slotName);
     }
     
     
     
     protected void commandLoop() {
          commandLoop(pointerToEnvironment);
     }
     
     
     
     public String getInputBuffer() {
          return getInputBuffer(pointerToEnvironment);
     }
     
     
     
     public void setInputBuffer(String theString) {
          setInputBuffer(pointerToEnvironment, theString);
     }
     
     
     
     public long getInputBufferCount() {
          return getInputBufferCount(pointerToEnvironment);
     }
     
     
     
     public long setInputBufferCount(long theValue) {
          return setInputBufferCount(pointerToEnvironment, theValue);
     }
     
     
     
     public void expandInputBuffer(char theChar) {
          expandInputBuffer(pointerToEnvironment, theChar);
     }
     
     
     
     public void appendInputBuffer(String theString) {
          appendInputBuffer(pointerToEnvironment, theString);
     }
     
     
     
     public boolean inputBufferContainsCommand() {
          return inputBufferContainsCommand(pointerToEnvironment);
     }
     
     
     
     public void commandLoopOnceThenBatch() {
          commandLoopOnceThenBatch(pointerToEnvironment);
     }
     
     
     
     public void printBanner() {
          printBanner(pointerToEnvironment);
     }
     
     
     
     public void printPrompt() {
          printPrompt(pointerToEnvironment);
     }
     
     
     
     public boolean addRouter(Router theRouter) {
          return addRouter(pointerToEnvironment, theRouter.getName(), theRouter.getPriority(), theRouter);
     }
     
     
     
     public void incrementFactCount(FactAddressValue theFact) {
          incrementFactCount(theFact.getEnvironment(), theFact.getEnvironment().getEnvironmentAddress(),
                    theFact.getFactAddress());
     }
     
     
     
     public void decrementFactCount(FactAddressValue theFact) {
          decrementFactCount(theFact.getEnvironment(), theFact.getEnvironment().getEnvironmentAddress(),
                    theFact.getFactAddress());
     }
     
     
     
     public void incrementInstanceCount(InstanceAddressValue theInstance) {
          incrementInstanceCount(theInstance.getEnvironment(), theInstance.getEnvironment().getEnvironmentAddress(),
                    theInstance.getInstanceAddress());
     }
     
     
     
     public void decrementInstanceCount(InstanceAddressValue theInstance) {
          decrementInstanceCount(theInstance.getEnvironment(), theInstance.getEnvironment().getEnvironmentAddress(),
                    theInstance.getInstanceAddress());
     }
     
     
     
     public void destroy() {
          destroyEnvironment(pointerToEnvironment);
     }
     
     
     
     public static void main(String args[]) {
          System.out.println(INFO_NOT_ALLOWED);
          System.out.println();
          // System.exit(0);
          //        Environment clips;
          //        clips = new Environment();
          //        clips.commandLoop();
          new Thread(new Runnable() {
             @Override
             public void run() {
                Environment innEng = new Environment();
                innEng.commandLoop();
             }}).start();
          
     }
}