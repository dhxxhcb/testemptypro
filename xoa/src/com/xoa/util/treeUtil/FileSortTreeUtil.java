package com.xoa.util.treeUtil;
import java.util.ArrayList;
import java.util.List;

import com.xoa.model.file.FileSortModel;


/**
 * 
 * @ClassName (类名):  FileSortTreeUtil
 * @Description(简述): 生成树结构工具类
 * @author(作者):      ys
 * @date(日期):        2017-4-17 下午4:32:41
 *
 */
public class FileSortTreeUtil {
	private final static String MENU_ID = "";
	
	
	
	List<FileSortModel> rootTree;
	List<FileSortModel> childTree;
	
	public FileSortTreeUtil(List<FileSortModel> rootTree,List<FileSortModel> childTree){
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
		for(FileSortModel fs : rootTree){
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
	private TreeNode RootToNode(FileSortModel fs){
		if(fs == null){
			return null;
		}
		TreeNode node = new TreeNode();
		node.setId(String.valueOf(fs.getSortId()));
		node.setDataId(String.valueOf(fs.getSortId()));
		node.setText(fs.getSortName());
		node.setParentId(String.valueOf(fs.getSortParent()));
		node.getAttributes().put("type", "0");
		node.getAttributes().put("id", fs.getSortId());
		return node;
	}
	
	/**
	 * @author 杨  胜       递归生成多层菜单
	 * @param rootNode
	 * @return
	 */
	private void addChlidNodes(TreeNode rootNode){
		List<TreeNode> childNodes = new ArrayList<TreeNode>();  
		for(FileSortModel fs: childTree){
			if(rootNode.getDataId().equals(String.valueOf(fs.getSortParent()))){
				TreeNode node = RootToNode(fs);
				childNodes.add(node);
				addChlidNodes(node);//如果本层找到子节点，则继续遍历下一子节点
			}
		}
		rootNode.setChildren(childNodes);
	}
}
