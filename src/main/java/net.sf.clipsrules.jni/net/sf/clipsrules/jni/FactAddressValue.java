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

public class FactAddressValue extends PrimitiveValue {
	private Environment theOwnerEnvironment;


	public FactAddressValue(long value, Environment env) {
		super(value);
		theOwnerEnvironment = env;
	}


	public Environment getEnvironment() {
		return theOwnerEnvironment;
	}


	public long getFactAddress() {
		return ((Long) getValue()).longValue();
	}


	/**
	 * @param slotName
	 * @return Environment.getFactSlot
	 * Modified from static to private. 
	 * @author FJ Aguayo (2022).
	 * @throws Exception
	 */
	public PrimitiveValue getFactSlot(String slotName) throws Exception {
		// return Environment.getFactSlot(this, slotName);
		return theOwnerEnvironment.getFactSlot(this, slotName);
	}


	/**
	 * @return long 
	 * Modified from static to private. 
	 * @author FJ Aguayo (2022).
	 */
	public long getFactIndex() {
		// return Environment.factIndex(this);
		return theOwnerEnvironment.factIndex(this);
	}


	
	public void retain() {
		theOwnerEnvironment.incrementFactCount(this);
	}


	
	public void release() {
		theOwnerEnvironment.decrementFactCount(this);
	}


	
	public String toString() {
		return "<Fact-" + getFactIndex() + ">";
	}
}
