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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultifieldValue extends PrimitiveValue {

	public MultifieldValue() {
		super(new ArrayList<Object>());
	}

	public MultifieldValue(List<?> value) {
		super(value);
	}

	public List<?> multifieldValue() {
		return (List<?>) getValue();
	}

	public PrimitiveValue get(int index) {
		List<?> theList = (List<?>) getValue();

		return (PrimitiveValue) theList.get(index);
	}

	/**
	 * @return int 
	 * Modified: List<?>. 
	 */
	public int size() {
		final List<?> theList = (List<?>) getValue();

		return theList.size();
	}

	public void retain() {
		final List<?> theList = (List<?>) getValue();

		for (Iterator<?> itr = theList.iterator(); itr.hasNext();) {
			PrimitiveValue pv = (PrimitiveValue) itr.next();
			pv.retain();
		}
	}

	public void release() {
		final List<?> theList = (List<?>) getValue();

		for (Iterator<?> itr = theList.iterator(); itr.hasNext();) {
			PrimitiveValue pv = (PrimitiveValue) itr.next();
			pv.release();
		}
	}

	public String toString() {
		final List<?> theList = (List<?>) getValue();
		boolean first = true;

		String theString = "(";

		for (Iterator<?> itr = theList.iterator(); itr.hasNext();) {
			if (!first) {
				theString = theString + " " + itr.next();
			} else {
				theString = theString + itr.next();
				first = false;
			}
		}

		theString = theString + ")";
		return theString;
	}
}
