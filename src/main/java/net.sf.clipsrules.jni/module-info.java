/**  *********************************************************
 *         "C" Language Integrated Production System         *
 *                                                           *
 *               CLIPS   Version 6.31   03/20/19             *
 *                                                           *
 *              CLIPSJNI Version 0.51c  25/06/22             *
 *************************************************************
 * Purpose:
 * 
 *   Compile:
 *   ------------------
 *   clipsjni-6.31-x86.jar    (jdk-1.8  all architectures-i586)
 *   clipsjni-6.31-x64.jar    (jdk-17 LTS all architectures-x64)
 *   
 *   Libraries: 
 *   ------------------ 
 *   clipsjni-6.31-x86.dll          (MsWindows 7-10/Intel-i586)
 *   clipsjni-6.31-x64.dll          (MsWindows 7-10/Intel-x64)
 *   libclipjni-6.31-x64.so         (GNU-x64 Linux Intel)
 *   libclipjni-6.31-osx64.jnilib   (OS X -Intel x64)
 *   libclipsjni-6.31-arm64.so      (GNU-x64 Linux ARM)
 *
 *
 * Objectives:
 * 
 * - Adapt CLIPSJNI.jar to JDK-17 LTS compiler (2022-2029) 
 * - Adapt CLIPSJNI.dll to x86/x64 Native Tools for VS (2022)
 * - Incorporate Java Module System to the library CLIPSJNI.jar.
 * - Allow safe loading of the Library depending on the
 *         architecture and the underlying operating system.
 * - Extract main() method from the main class Environment().
 * - Incorporate a Shell Class with safe thread to CLIPS-Shell.  
 * 
 *************************************************************
 * Principal Programmer(s):
 *      Gary D. Riley
 *
 *
 * Contributing Programmer(s):
 *      Francisco J. Aguayo
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
module net.sf.clipsrules.jni {
    exports net.sf.clipsrules.jni;
    uses net.sf.clipsrules.jni.PrimitiveValue;
    uses net.sf.clipsrules.jni.FactAddressValue;
}