/*
 * Copyright (C) 2015 Alexander Christian <alex(at)root1.de>. All rights reserved.
 * 
 * This file is part of KonnektingDevice XML Schema.
 *
 *   KonnektingDevice XML Schema is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   KonnektingDevice XML Schema is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with KonnektingDevice XML Schema.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.konnekting.xml.konnektingdevice.v0;

/**
 * parameter Types.
 * String and Raw can contain up to 11 byte
 * @author achristian
 */
public enum ParameterType {
    
    UINT8, INT8, UINT16, INT16, UINT32, INT32, RAW1, RAW2, RAW3, RAW4, RAW5, RAW6, RAW7, RAW8, RAW9, RAW10, RAW11;
    
}
