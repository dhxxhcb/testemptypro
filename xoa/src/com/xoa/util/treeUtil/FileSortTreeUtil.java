package com.xoa.util.treeUtil;
import java.util.ArrayList;
import java.util.List;

import com.xoa.model.file.File_Sort;



public class FileSortTreeUtil {
	private final static String MENU_ID = "";
	
	
	
	List<File_Sort> rootTree;
	List<File_Sort> childTree;
	
	public FileSortTreeUtil(List<File_Sort> rootTree,List<File_Sort> childTree){
		this.rootTree = rootTree;
		this.childTree = childTree;
	}  
	
	
	public List<TreeNode> getTreeNode(){
		return getRootNodes();
	}
	
	
     /**
      * @author 杨  胜
      * @return  List<TreeNode>
      */
	private List<TreeNode>  getRootNodes(){
		List<TreeNode> rootNodes = new ArrayList<TreeNode>();
		for(File_Sort fs : rootTree){
			TreeNode node = RootToNode(fs);
			if(node != null){
				addChlidNodes(node);
				rootNodes.add(node);
			}
		}
		return rootNodes;
	}
	
	/**
	 * @author 杨  胜
	 * @param menu
	 * @return
	 */
	private TreeNode RootToNode(File_Sort fs){
		if(fs == null){
			return null;
		}
		TreeNode node = new TreeNode();
		node.setId(String.valueOf(fs.getSort_id()));
		node.setDataId(String.valueOf(fs.getSort_id()));
		node.setText(fs.getSort_name());
		node.setParentId(String.valueOf(fs.getSort_parent()));
		node.getAttributes().put("type", "0");
		node.getAttributes().put("id", fs.getSort_id());
		return node;
	}
	
	/**
	 * @author 杨  胜       递归生成多层菜单
	 * @param rootNode
	 * @return
	 */
	private void addChlidNodes(TreeNode rootNode){
		List<TreeNode> childNodes = new ArrayList<TreeNode>();  
		boolean flag=false;
		for(File_Sort fs: childTree){
			if(rootNode.getDataId().equals(String.valueOf(fs.getSort_parent()))){
				TreeNode node = RootToNode(fs);
				childNodes.add(node);
				addChlidNodes(node);//如果本层找到子节点，则继续遍历下一子节点
			}
		}
		rootNode.setChildren(childNodes);
	}
}
