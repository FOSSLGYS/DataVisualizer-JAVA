# DataVisualizer-JAVA

### Project Description
Data visualizer is a Java based application designed to give a text based visual representation of various data structures, currently, stacks, queues, lists, binary search tree and binary min heap. It provides an easy to add framework so that additional data structuress may be added in future.

### Tools and Technology
The project has been developed in NetBeans IDE, using JAVA Swing framework for GUI elements.

### The Repository Details
The repository consists of a single "src" folder, which is the root of the three packages used by the JAVA files. This "src" folder can be used as the Source Folder within any JAVA based IDE. Specific instructions on how to download, setup and run using NetBeans are present in the [Instructions Wiki](https://github.com/FOSSLGYS/DataVisualizer-JAVA/wiki).

The three pakcages: com.tapia.foss.ds, com.tapia.foss.frames and com.tapia.foss.images follow the standard folder hierarchy. i.e.,

* com > tapia > foss > ds
* com > tapia > foss > frames
* com > tapia > foss > images

The "ds" and "frames" folders contain the code files and "images", as the name suggests, contains images. All the frame/GUI based logic is present inside the "frames" package and is independent of the data structures that it is displaying. The data structures are present in side the "ds" package and are independent of frame/GUI based logic. All data structures inherit from a single DataStructure interface to give them conformity and enable separation of concern between the data structure and the frame/GUI logic.

### How to work on an Issue
1. You can view the open issues for the repository under [Issues](https://github.com/FOSSLGYS/DataVisualizer-JAVA/issues). If there is a particular existing issue that you would like to fix, please leave a comment below it with *intent and details of how you intend to fix it*. This will reduce duplication of effort. 
2. If you would like to propose an enhancement, or report a bug that you would like to work on, feel free to open new issues and we will assign them to you.

### How to get help
Have questions, comments, feedback or looking for help? We are available and can be reached at the [Slack channel](https://fosslgys.slack.com) created specifically for this project. *IRC channels are so a thing of the past!* If you are having trouble signing up, you can reach us at fosslgys@gmail.com for signup help.
