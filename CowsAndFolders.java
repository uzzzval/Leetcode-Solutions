package cows.and.folders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Scanner;
import java.util.Set;


public class Node {
	private int data;
	private List<Integer> accesspeople;
	private Node leftNode;
	private Node rightNode;

	public Node() {

	}

	public static void main(String args[]) throws IOException {

		Scanner reader = new Scanner(System.in);
		int noOfCows = Integer.parseInt(reader.nextLine());
		Set<Integer> cowsSet=new HashSet<Integer>();
		for(int i=0;i<noOfCows;i++) {
			cowsSet.add(i);
		}

		String noOfFolders=reader.nextLine();
		
		
		String[] noOfFoldersArray=noOfFolders.split(" ");

		int sharedFolders=Integer.parseInt(noOfFoldersArray[0]);
		int confidentialFolders=Integer.parseInt(noOfFoldersArray[1]);
		
		List<String> inputStrings=new ArrayList<String>();
		List<Integer> sharedFoldersList=new ArrayList<Integer>();
		List<Integer> confidentialFoldersList=new ArrayList<Integer>();

		for(int i=0;i<sharedFolders;i++) {
			String string=reader.nextLine();
			String[] folders=string.split(" ");
			sharedFoldersList.add(Integer.parseInt(folders[0]));
			inputStrings.add(string);
		}

		for(int i=0;i<confidentialFolders;i++) {
			String string=reader.nextLine();
			String[] folders=string.split(" ");
			confidentialFoldersList.add(Integer.parseInt(folders[0]));
			inputStrings.add(string);
		}

		int noOfRelations=Integer.parseInt(reader.nextLine());
		List<String> relations=new ArrayList<String>();
		for(int i=0;i<noOfRelations;i++) {
			relations.add(reader.nextLine());
		}

		//Populating the folder Information Map
		Map<Integer,List<Integer>> folderInfoMap=new HashMap<Integer,List<Integer>>();
		for(int i=0;i<inputStrings.size();i++) {
			String[] stringArray=inputStrings.get(i).split(" ");
			int folderId=Integer.parseInt(stringArray[0]);
			int noOfMembers=Integer.parseInt(stringArray[1]);
			List<Integer> localList=new ArrayList<Integer>();
			for(int j=2;j<2+noOfMembers;j++)
				localList.add(Integer.parseInt(stringArray[j]));
			folderInfoMap.put(folderId, localList);
		}
		reader.close();
		System.out.println(folderInfoMap);
		//Populating the Relation Map
		Map<Integer,List<Integer>> relationMap=new HashMap<Integer,List<Integer>>();
		for(int i=0;i<relations.size();i++) {
			String[] stringArray=relations.get(i).split(" ");
			int parentFolder=Integer.parseInt(stringArray[0]);
			int childFolder=Integer.parseInt(stringArray[1]);

			if(relationMap.get(parentFolder)!=null) {
				List<Integer> localSet=relationMap.get(parentFolder);
				localSet.add(childFolder);
				relationMap.put(parentFolder, localSet);
			}else {
				List<Integer> localSet=new ArrayList<Integer>();
				localSet.add(childFolder);
				relationMap.put(parentFolder, localSet);
			}
		}


		//Creating the tree
		Node rootNode=null;

		Iterator<Entry<Integer, List<Integer>>> relationMapIterator=relationMap.entrySet().iterator();
		while(relationMapIterator.hasNext()) {
			Entry<Integer,List<Integer>> pair=relationMapIterator.next();
			int folderId=pair.getKey();
			List<Integer> relatedNodes=pair.getValue();
			Node folder=new Node();
			folder.data=folderId;

			rootNode=addNodeToTree(rootNode,folder,relatedNodes);
		}

		accessDistribution(rootNode,folderInfoMap);

		accessSync(rootNode,sharedFoldersList);
		Set<Integer> unCoolList=new HashSet<Integer>();
		findUnCool(rootNode,unCoolList,cowsSet);
		System.out.println("Uncoollist"+unCoolList);

	}



	private static void findUnCool(Node rootNode, Set<Integer> unCoolList, Set<Integer> cowsSet) {
		if(rootNode==null) {
			return;
		}
		Set<Integer> tempSet=cowsSet;
		if(rootNode.leftNode!=null) {
			findUnCool(rootNode.leftNode,unCoolList,cowsSet);
		}else {
			Set<Integer> accessSet=new HashSet<Integer>(rootNode.accesspeople);
			tempSet.removeAll(accessSet);
			if(!tempSet.isEmpty())
				unCoolList.addAll(tempSet);
		}
		tempSet=cowsSet;
		if(rootNode.rightNode!=null) {
			findUnCool(rootNode.rightNode,unCoolList,cowsSet);
		}else {
			Set<Integer> accessSet=new HashSet<Integer>(rootNode.accesspeople);
			tempSet.removeAll(accessSet);
			if(!tempSet.isEmpty()) 
				unCoolList.addAll(tempSet);
		}
	}

	private static void accessSync(Node rootNode, List<Integer> sharedFoldersList) {
		if(rootNode==null) {
			return ;
		}

		if(rootNode.leftNode!=null) {
			List<Integer> accessList=rootNode.accesspeople;

			if(sharedFoldersList.contains(rootNode.leftNode.data)) {
				rootNode.leftNode.accesspeople.addAll(accessList);
			}
			accessSync(rootNode.leftNode,sharedFoldersList);
		}
		if(rootNode.rightNode!=null) {

			List<Integer> accessList=rootNode.accesspeople;
			if(sharedFoldersList.contains(rootNode.rightNode.data)) {
				rootNode.accesspeople.addAll(accessList);
			}
			accessSync(rootNode.rightNode,sharedFoldersList);
		}	
	}

	private static void accessDistribution(Node root, Map<Integer, List<Integer>> relationMap) {
		if(root==null) {
			return ;
		}
		int nodeValue=root.data;
		List<Integer> accessList=relationMap.get(nodeValue);
		root.accesspeople=accessList;
		if(root.leftNode!=null) {
			accessDistribution(root.leftNode,relationMap);
		}
		if(root.rightNode!=null) {
			accessDistribution(root.rightNode,relationMap);
		}
	}

	private static Node addNodeToTree(Node headerNode, Node node,List<Integer> relatedNodes) {
		if(headerNode==null) {
			headerNode=node;
		}
		Node returnNode=headerNode;
		if(headerNode.data==node.data) {
			if(relatedNodes.get(0)!=null) {
				Node leftNode=new Node();
				leftNode.data=relatedNodes.get(0);
				headerNode.leftNode=leftNode;
			}

			if(relatedNodes.get(1)!=null) {
				Node rightNode=new Node();
				rightNode.data=relatedNodes.get(1);
				headerNode.rightNode=rightNode;
			}

		}else {
			if(headerNode.leftNode!=null)
				addNodeToTree(headerNode.leftNode,node,relatedNodes);
			if(headerNode.rightNode!=null)
				addNodeToTree(headerNode.rightNode,node,relatedNodes);
		}

		return returnNode;
	}

}
