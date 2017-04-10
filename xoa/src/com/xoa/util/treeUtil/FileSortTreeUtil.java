package com.xoa.util.treeUtil;
import java.util.ArrayList;
import java.util.List;

import com.xoa.model.file.File_Sort;



public class FileSortTreeUtil {
	private final static String MENU_ID = "";
	
	private final static String BTN_ID = "btn_";
	
	
	List<File_Sort> rootMenus;
	List<File_Sort> childMenus;
	
	public FileSortTreeUtil(List<File_Sort> rootMenus,List<File_Sort> childMenus){
		this.rootMenus = rootMenus;
		this.childMenus = childMenus;
	}  
	
	public FileSortTreeUtil(List<File_Sort> rootMenus,List<File_Sort> childMenus,List<File_Sort> childBtns){
		this.rootMenus = rootMenus;
		this.childMenus = childMenus;
		
	}  
	
	public List<TreeNode> getTreeNode(){
		return getRootNodes();
	}
	
	/**
	 * 
	 * @param menu
	 * @return
	 */
	private TreeNode MenuToNode(File_Sort menu){
		if(menu == null){
			return null;
		}
		TreeNode node = new TreeNode();
		node.setId(MENU_ID+menu.getSort_id());
		node.setDataId(String.valueOf(menu.getSort_id()));
		node.setText(menu.getSort_name());
		node.setParentId(String.valueOf(menu.getSort_parent()));
		node.getAttributes().put("type", "0");
		node.getAttributes().put("id", menu.getSort_id());
		return node;
	}
	
	
	/**
	 * 
	 * @param menu
	 * @return
	 
	private TreeNode BtnToNode(AdminWidgetrule btn){
		if(btn == null){
			return null;
		}
		TreeNode node = new TreeNode();
		node.setId(BTN_ID+btn.getRule_id());
		node.setDataId(btn.getRule_id()+"");
		node.setText(btn.getRule_name());
		node.setParentId(btn.getRes_id()+"");
		node.getAttributes().put("type", "1");
		node.getAttributes().put("id", btn.getRule_id());
		return node;
	}
*/
	private List<TreeNode> getRootNodes(){
		List<TreeNode> rootNodes = new ArrayList<TreeNode>();
		for(File_Sort menu : rootMenus){
			TreeNode node = MenuToNode(menu);
			if(node != null){
				addChlidNodes(node);
				rootNodes.add(node);
			}
		}
		return rootNodes;
	}
	
	/**
	 * 两层菜单
	 * @param menu
	 * @return
	 
	private void addChlidNodes(TreeNode rootNode){
		List<TreeNode> childNodes = new ArrayList<TreeNode>();  
		for(AppOrganization menu : childMenus){
			if(rootNode.getDataId().equals(menu.getPorgna_id())){
				TreeNode node = MenuToNode(menu);
				//if(childBtns != null && !childBtns.isEmpty()){
				//	addChlidBtn(node);
				//}
				childNodes.add(node);
			}
		}
		rootNode.setChildren(childNodes);
	}
	*/
	/**
	 * 多层菜单
	 * @param menu
	 * @return
	 */
	private void addChlidNodes(TreeNode rootNode){
		List<TreeNode> childNodes = new ArrayList<TreeNode>();  
		boolean flag=false;
		for(File_Sort menu : childMenus){
			if(rootNode.getDataId().equals(menu.getSort_parent())){
				TreeNode node = MenuToNode(menu);
				//if(childBtns != null && !childBtns.isEmpty()){
				//	addChlidBtn(node);
				//}
				childNodes.add(node);
				addChlidNodes(node);//如果本层找到子节点，则继续遍历下一子节点
			}
		}
		
		rootNode.setChildren(childNodes);
	}
	
	/**
	 * 设置菜单button
	 * @param menu
	 * @return
	 
	private void addChlidBtn(TreeNode treeNode){
		List<TreeNode> childNodes = new ArrayList<TreeNode>(); 
		for(AdminWidgetrule btn : childBtns){
			if(treeNode.getDataId().equals(btn.getRes_id())){
				TreeNode node = BtnToNode(btn);
				childNodes.add(node);
			}
		}
		treeNode.setChildren(childNodes);
	}
	*/
	
	
}
