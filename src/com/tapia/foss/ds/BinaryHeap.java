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
public class BinaryHeap implements DataStructure{
    
    //Implementinig Binary Heap operations using ArrayList Container
    ArrayList<Node> minHeap;
    
    //CONSTRUCTOR
    public BinaryHeap()
    {
        minHeap = new ArrayList<>(Utility.STEP_SIZE);
    }
    
    /**
     * ADD method implementation
     * @param element, an Integer to be added to the Binary Min Heap
     */
    @Override
    public void add(Integer element)
    {
        minHeap.add(new Node(element));
        
        if(size()>1)
        {
            //maintainig pointers for easy printing
            int p = parent(size()-1);
            if(size()-1 == leftChild(p))
                minHeap.get(p).setLeft(minHeap.get(size()-1));
            else
                minHeap.get(p).setRight(minHeap.get(size()-1));
            
            heapifyUp(size()-1);
        }
    }
    
    
    /**
     * Adding random values to the Binary Min Heap
     */
    @Override
    public void addRandomValues()
    {
        Random randomGenerator = new Random();
        for(int i =0;i<Utility.STEP_SIZE;i++)
            add(randomGenerator.nextInt(100));      
    }
    
    /**
     * DELETE root (minimum) from Binary Min Heap
     * @param ignore, required for consistency across data structures, unused here
     * @return a Boolean value to indicate whether the removal was successful or not
     */
    @Override
    public Boolean remove(Integer ignore)
    {
        if(size()==0)
            return false;
        
        if(size()==1)
        {
            minHeap.clear();
            return true;
        }
        
        Node lastNode = minHeap.remove(size()-1);
        
        //maintainig pointers for easy printing
        int p = parent(size()-1);
        if(size()-1 == leftChild(p))
            minHeap.get(p).setLeft(null);
        else
            minHeap.get(p).setRight(null);
            
        minHeap.get(0).setData(lastNode.getData());
        heapifyDown(0);
        return true;
    }
    
    /**
    *EMPTY the Binary Min Heap
    */
    @Override
    public void removeAll()
    {
        minHeap.clear();
    }
           
    /**
    * Get SIZE of the Binary Min Heap
    * @return the number of elements in the Binary Min Heap
    */
    @Override
    public Integer size()
    {
        return minHeap.size();
    }
    
    /**
     * Get DISPLAY string, to visualize the Binary Min Heap
     * @param columns the number of columns in the final display area (TextArea)
     * @return a formatted string to display the current state of the Min Heap
     */
    @Override
    public String getDisplayString(int columns)
    {
        if(size()==0)
            return "";
        
        String displayString=Utility.getDisplayString(minHeap.get(0));
        return displayString;
    }
    
    
    private int parent(Integer i)
    {
        return (int)Math.floor((i-1)/2);
    }
    
    private int leftChild(Integer i)
    {
        return 2*i+1;
    }
    
    private int rightChild(Integer i)
    {
        return 2*i+2;
    }
    
    private void heapifyUp(Integer curIndex)
    {
        int temp = minHeap.get(curIndex).getData();
        
        while(curIndex>0 && temp < minHeap.get(parent(curIndex)).getData())
        {
            minHeap.get(curIndex).setData(minHeap.get(parent(curIndex)).getData());
            curIndex=parent(curIndex);
        }
        
        minHeap.get(curIndex).setData(temp);
    }
    
    private void heapifyDown(Integer curIndex)
    {
        int temp = minHeap.get(curIndex).getData();
        
        while(leftChild(curIndex)<size())
        {
            int child = minChild(curIndex);
            
            if(minHeap.get(child).getData()<temp)
            {
                minHeap.get(curIndex).setData(minHeap.get(child).getData());
                minHeap.get(child).setData(temp);
            }
            curIndex=child;
        }
    }
    
    private Integer minChild(Integer curIndex)
    {
        if(rightChild(curIndex)>=size())
            return leftChild(curIndex);
        else
        {
            if(minHeap.get(leftChild(curIndex)).getData()<minHeap.get(rightChild(curIndex)).getData())
                return leftChild(curIndex);
            else
                return rightChild(curIndex);
        }
    }
}
