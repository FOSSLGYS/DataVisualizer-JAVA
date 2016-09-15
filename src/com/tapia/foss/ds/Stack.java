/*
 * Copyright (C) 2015 banjum
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tapia.foss.ds;

import java.util.*;

/**
 *
 * @author banjum
 */
public class Stack implements DataStructure {
    
    //Implementinig Stack operations using ArrayList Container
    ArrayList<Integer> stack;
    
    
    //CONSTRUCTOR
    public Stack()
    {
        stack = new ArrayList<>(Utility.STEP_SIZE);
    }
    
    /**
     * PUSH method implementation
     * @param element, an Integer value to be pushed at the top of the stack
     */
    @Override
    public void add(Integer element)
    {
        stack.add(element);
    }
    
    
    /**
     * Adding random values to the Stack
     */
    @Override
    public void addRandomValues()
    {
        Random randomGenerator = new Random();
        for(int i =0;i<Utility.STEP_SIZE;i++)
            add(randomGenerator.nextInt(100));      
    }
    
    /**
     * POP method for Stack
     * @param ignore, required for consistency across data structures, unused here
     * @return a Boolean value to indicate whether the removal was successful or not
     */
    @Override
    public Boolean remove(Integer ignore)
    {
        // Nothing to remove from the stack
        if (stack.size() <= 0) {
            return false;
        } else {
            stack.remove(stack.get(size()-1));
            return true;
        }
    }
    
    /**
    *EMPTY the Stack
    */
    @Override
    public void removeAll()
    {
        stack.clear();
    }
           
    /**
    * Get SIZE of the Stack
    * @return the number of elements in the Stack
    */
    @Override
    public Integer size()
    {
        return stack.size();
    }
    
    /**
     * Get DISPLAY string, to visualize the Stack 
     * @param columns the number of columns in the final display area (TextArea)
     * @return a formatted string to display the current state of the Stack
     */
    @Override
    public String getDisplayString(int columns)
    {
        String displayString=addHeadPointer(columns);
        
        for(int i = size()-1;i>=0;i--)
        {
            displayString+=stack.get(i);
            displayString+="\n";
            displayString+=Utility.addSpaces(columns/2);
        }
        
        return displayString;
    }
    
    /***************************
    //PRIVITE UTILITY FUNCTIONS
    ***************************/
    
    //Create a string with appropriate spaces and a representation
    //of a TOP arrow, pointing to the top of the Stack
    private String addHeadPointer(int x)
    {
        String head = "          TOP --->  ";
        String str="\n";
        
        for(int i =0; i < ((x/2)-head.length()-1) ;i++)
            str+=" ";
        
        str+=head;
        return str;
    }
        
}
