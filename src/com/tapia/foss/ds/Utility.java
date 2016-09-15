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
import java.util.Collections;
import java.util.List;

/**
 *
 * @author banjum
 */
public class Utility {
    
    //Initial capacity is set as 10 elements
    //Also is used as step size for random entries
    static final Integer STEP_SIZE=10;
    
    //Code referenced from Stack Overflow post
    //http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
    
    public static String getDisplayString(Node root)
    {
        String displayString;
        
        int maxLevel = maxLevel(root);
        displayString=getDisplayString(Collections.singletonList(root), 1, maxLevel);
        
        return displayString;
    }
    
    private static String getDisplayString(List<Node> nodes, int level, int maxLevel)
    {
        String displayString="";
        
        if(nodes.isEmpty() || isAllElementsNull(nodes))
            return displayString;
        
        int floor = maxLevel - level+1;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) ;

        displayString+=addSpaces(firstSpaces);
        
        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                displayString+=node.getData();
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                displayString+="  ";
            }

            displayString+=addSpaces(betweenSpaces-2);
        }
        displayString+="\n";
        
        for (int i = 1; i <= endgeLines; i++) {
            for (Node node : nodes) {
                displayString+=addSpaces(firstSpaces - i);
                if (node == null) {
                    displayString+=addSpaces(endgeLines + endgeLines + i + 1);
                    continue;
                }
                if (node.left != null) {
                    displayString+="/";
                } else {
                    displayString+=addSpaces(1);
                }
                displayString+=addSpaces(i + i - 1);
                if (node.right != null) {
                    displayString+="\\";
                } else {
                    displayString+=addSpaces(1);
                }
                displayString+=addSpaces(endgeLines + endgeLines - i);
            }

            displayString+="\n";
        }

        return displayString+=(getDisplayString(newNodes, level + 1, maxLevel));
        
    }

    private static int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
    }
     
    private static boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
    
    public static String addSpaces(int n)
    {
        String str="";
        for(int i =0;i<n;i++)
            str+=" ";
        return str;
    }
    
}
