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

/**
 * Class Node will be used by the class BinaryTree Binary to implement a
 * Binary Search Tree data structure
 * @author banjum
 */
public class Node {
    Node left, right;
    Integer data;
    
    public Node()
    {
        left=right=null;
        data=0;
    }
    
    public Node(Integer val)
    {
        left=right=null;
        data=val;
    }
    
    public void setLeft(Node n)
    {
        left=n;
    }
    
    public void setRight(Node n)
    {
        right=n;
    }
    
    public Node getLeft()
    {
        return left;
    }
    
    public Node getRight()
    {
        return right;
    }
    
    public void setData(Integer val)
    {
        data=val;
    }
    public Integer getData()
    {
        return data;
    }
    
    //Recursive REMOVE function to find and remove a node from a
    //Binary Search Tree to which the parameter Node "parent" belong
    public boolean removeBST(int value, Node parent) 
    {
        if (value < data) 
        {
            if (left != null)
                return left.removeBST(value, this);
            else
                return false;
        }
        else if (value > data) 
        {
            if (right != null)
                return right.removeBST(value, this);
            else
                return false;
        }
        else
        {
            if (left != null && right != null) 
            {
                this.data = right.minValue();
                right.removeBST(data, this);
            }
            else if (parent.left == this) 
            {
                parent.left = (left != null) ? left : right;
            }
            else if (parent.right == this) 
            {
                parent.right = (left != null) ? left : right;
            }
            return true;
        }
    }
    
    private Integer minValue() 
    {
        if (left == null)
            return data;
        else
            return left.minValue();
    }
}
