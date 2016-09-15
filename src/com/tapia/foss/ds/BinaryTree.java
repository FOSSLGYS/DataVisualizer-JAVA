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

import java.util.Random;

/**
 *
 * @author banjum
 */
public class BinaryTree implements DataStructure{
    
    //Root node of the binary search tree
    private Node root;
    
    //CONSTRUCTOR
    public void BinaryTree()
    {
        root=null;
    }
    
    /**
     * Adding random values to the Binary Tree
     */
    @Override
    public void addRandomValues()
    {
        Random randomGenerator = new Random();
        
        //Adding probabilistically balanced values
        for(int i =0;i<Utility.STEP_SIZE;i++)
        {
            int r = randomGenerator.nextInt(2);
            if(r==0)
                add(randomGenerator.nextInt(50));
            else
                add(randomGenerator.nextInt(50)+50);
        }
    }
    
    /**
     * ADD node method implementation
     * @param element, an Integer value to be added to the Binary Tree
     * Method calls a private recursive add() method to get to the appropriate node and add a new node
     */
    @Override
    public void add(Integer element)
    {
        root = add(element,root);
    }
    
    /**
     * REMOVE node method implementation
     * @param element, an Integer value to be removed from the Binary Tree
     * Method calls a private recursive remove() method to search and delete the node
     * @return a Boolean value to indicate whether the removal was successful or not
     */
    @Override
    public Boolean remove(Integer element)
    {
         if (root == null)
            return false;
        else 
        {
            if (root.getData().equals(element)) 
            {
                Node auxRoot = new Node();
                auxRoot.setLeft(root);
                boolean result = root.removeBST(element, auxRoot);
                root = auxRoot.getLeft();
                return result;
            }
            else
            {
                return root.removeBST(element, null);
            }
        }
    }
    
    /**
    *EMPTY the Tree
    */
    @Override
    public void removeAll()
    {
        root=removeAll(root);
    }
    
    /**
     * COUNT the number of nodes in the Binary Search Tree
     * @return COUNT
     */
    @Override
    public Integer size()
    {
        return size(root);
    }
    
    /**
     * Get DISPLAY string, to visualize the Binary Search Tree 
     * @param columns the number of columns in the final display area (TextArea)
     * @return a formatted string to display the current state of the Tree
     */
    @Override
    public String getDisplayString(int columns)
    {
        String displayString=Utility.getDisplayString(root);
        return displayString;
    }
    
    //*******************************************************//
    //**********PRIVATE RECURSIVE FUNCTIONS *****************//
    //*******************************************************//
    
    //ADD a node to the Binary Search Tree - recursive counterpart
    private Node add(Integer element, Node node)
    {
        if(node==null)
        {
            node = new Node(element);
        }
        else
        {
            if(element<node.getData())
                node.setLeft(add(element,node.getLeft()));
            else
                node.setRight(add(element, node.getRight()));
        }
        
        return node;
    }

    //REMOVE ALL nodes from the Binary Search Tree - recursive counterpart
    private Node removeAll(Node node)
    {
        if(node==null)
            return null;
        
        if(node.getLeft()==null && node.getRight()==null)
            node=null;
        else
        {
            node.setLeft(removeAll(node.getLeft()));
            node.setRight(removeAll(node.getRight()));
        }
        
        return null;
    }

    //COUNT the number of nodes in the Binary Search Tree - recursive counterpart
    private Integer size(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            int count = 1;
            count += size(node.getLeft());
            count += size(node.getRight());
            return count;
        }
    }
}