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

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author banjum
 */
public class Queue implements DataStructure{
    
    //Implementinig Queue operations using ArrayList Container
    ArrayList<Integer> queue;
    
     public Queue()
    {
        queue = new ArrayList<>(Utility.STEP_SIZE);
    }
    
    /**
     * EN-QUEUE method implementation
     * @param element, an Integer to be enqueued at the end of the queue
     */
    @Override
    public void add(Integer element)
    {
        queue.add(element);
    }
    
    /**
     * Adds random values to the Queue
     */
    @Override
    public void addRandomValues()
    {
        Random randomGenerator = new Random();
        for(int i =0;i<Utility.STEP_SIZE;i++)
            add(randomGenerator.nextInt(100));

    }
    /**
     * DE-QUEUE method for Queue
     * @param ignore, required for consistency across data structures, unused here
     * @return a Boolean value to indicate whether the removal was successful or not
     */
    @Override
    public Boolean remove(Integer ignore)
    {
        queue.remove(0);
        return true;
    }
    
    /**
    *EMPTY the Queue
    */
    @Override
    public void removeAll()
    {
        for(int i =0;i<size();i++)
            queue.remove(0);
    }
    
    /**
    * Get SIZE of the Queue
    * @return the number of elements in the Queue
    */
    @Override
    public Integer size()
    {
        return queue.size();
    }
    
    /**
     * Get DISPLAY string, to visualize the Queue 
     * @param columns the number of columns in the final display area (TextArea)
     * @return a formatted string to display the current state of the Queue
     */
    @Override
    public String getDisplayString(int columns)
    {
        String displayString=addHeadPointer(columns);
        
        if(size()==0)
            displayString+=Utility.addSpaces(9);
        else
            displayString+=Utility.addSpaces(5);
        
        for(int i = 0;i<size();i++)
        {
            displayString+=queue.get(i);
            displayString+=Utility.addSpaces(3);
        }
        //displayString+="\n";
        
        int begin = displayString.lastIndexOf("\n");
        int end = displayString.length();
        displayString+=addTailPointer(end-begin-5);
        return displayString;
    }
    
    /***************************
    //PRIVITE UTILITY FUNCTIONS
    ***************************/
    //Create a string with appropriate spaces and a representation
    //of a HEAD arrow, pointing to the front of the Queue
    private String addHeadPointer(int x)
    {
        String head = "\n   HEAD\n     |\n     |\n     *\n";
        return head;
    }
    //Create a string with appropriate spaces and a representation
    //of a TAIL arrow, pointing to the end of the Queue
    private String addTailPointer(int len)
    {
        String tail = "\n";
        for(int i =0;i<len;i++)
            tail+=" ";
        tail+="*\n";
        for(int i =0;i<len;i++)
            tail+=" ";
        tail+="|\n";
        for(int i =0;i<len;i++)
            tail+=" ";
        tail+="|\n";
        for(int i =0;i<len-2;i++)
            tail+=" ";
        tail+="TAIL\n";
        return tail;
    }
      
}
