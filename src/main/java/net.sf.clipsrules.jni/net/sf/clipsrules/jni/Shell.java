/** **********************************************************
 * Principal Programmer(s):
 *      Gary D. Riley
 *
 *
 * Contributing Programmer(s):
 *      FJ Aguayo
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

/**
 * New class to eliminate from Environment its main() method.
 * NOTE: 
 *    This class generates another clips-engine instance, 
 *    separate from engine at Environment class.
 *    So, this engine is only for Human-actor (Domain-Experts or Developers).
 *    
 * @author FJ Aguayo
 */
public class Shell {

	private Shell() {} // Lock-System.

	public static void main(String args[]) {

		class RunCLIPSconsole implements Runnable {
			
			Environment innEng = new Environment();
			@Override
			public void run() {
				innEng.commandLoop();
			}
		}

		RunCLIPSconsole runThread = new RunCLIPSconsole();
		Thread thread = new Thread(runThread);
		thread.start();
	}

}
