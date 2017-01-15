package algoritham.java.com.vaquar.tree;

/**
 * This code will ensure holding of chain(links) of nodes from the root to till the level of the tree.
 * The number of extra nodes in the memory (other than tree) is height of the tree.
 * I haven't used java stack instead used this ParentChain. 
 * This parent chain is the link for any node from the top(root node) to till its immediate parent.
 * This code will not require any altering of existing BinaryTree (NO flag/parent on all the nodes).
 *  
 *  while visiting the Node 11; ParentChain will be holding the nodes 9 -> 8 -> 7 -> 1 where (-> is parent)
 *  
 *             1                               
              / \               
             /   \              
            /     \             
           /       \            
          /         \           
         /           \          
        /             \         
       /               \        
       2               7               
      / \             /         
     /   \           /          
    /     \         /           
   /       \       /            
   3       6       8               
  / \             /             
 /   \           /              
 4   5           9               
                / \             
                10 11
                     
 *               
 * 
 *
 */
public class InOrderTraversalIterative {
	public static void main(String[] args) {
		BTNode<String> rt;
		String[] dataArray = {"1","2","3","4",null,null,"5",null,null,"6",null,null,"7","8","9","10",null,null,"11",null,null,null,null};
		rt = BTNode.buildBTWithPreOrder(dataArray, new Counter(0));
		BTDisplay.printTreeNode(rt);
		inOrderTravesal(rt);
	}
	
	public static void inOrderTravesal(BTNode<String> root) {
		ParentChain rootChain = new ParentChain(root);
		rootChain.Parent = new ParentChain(null);
		
		while (root != null) {
			
			//Going back to parent
			if(rootChain.leftVisited && rootChain.rightVisited) {
				ParentChain parentChain = rootChain.Parent;
				rootChain.Parent = null; //Avoid the leak / Return to pool.
				rootChain = parentChain;
				root = rootChain.root;
				continue;
			}
			
			//Traverse Left
			if(!rootChain.leftVisited) {
				rootChain.leftVisited = true;
				if (root.left != null) {
					ParentChain local = new ParentChain(root.left); //It is better to use pool to reuse the instances.
					local.Parent = rootChain;
					rootChain = local;
					root = root.left;
					continue;
				}
			} 
			
			System.out.println(root.data); //Visit the node.
			
			//Traverse RIGHT
			if(!rootChain.rightVisited) {
				rootChain.rightVisited = true;
				if (root.right != null) {
					ParentChain local = new ParentChain(root.right); //It is better to use pool to reuse the instances.
					local.Parent = rootChain;
					rootChain = local;
					root = root.right;
					continue;
				}
			}
		}
	}
	
	
	public static void postOrderTravesal(BTNode<String> root) {
		ParentChain rootChain = new ParentChain(root);
		rootChain.Parent = new ParentChain(null);
		
		while (root != null) {
			
			//Going back to parent
			if(rootChain.leftVisited && rootChain.rightVisited) {
				System.out.println(root.data); //Visit the node.
				ParentChain parentChain = rootChain.Parent;
				rootChain.Parent = null; //Avoid the leak
				rootChain = parentChain;
				root = rootChain.root;
				continue;
			}
			
			//Traverse Left
			if(!rootChain.leftVisited) {
				rootChain.leftVisited = true;
				if (root.left != null) {
					ParentChain local = new ParentChain(root.left); //It is better to use pool to reuse the instances.
					local.Parent = rootChain;
					rootChain = local;
					root = root.left;
					continue;
				}
			} 
			
			//Traverse RIGHT
			if(!rootChain.rightVisited) {
				rootChain.rightVisited = true;
				if (root.right != null) {
					ParentChain local = new ParentChain(root.right); //It is better to use pool to reuse the instances.
					local.Parent = rootChain;
					rootChain = local;
					root = root.right;
					continue;
				}
			}
		}
	}
	
	
	
	public static void preOrderTravesal(BTNode<String> root) {
		ParentChain rootChain = new ParentChain(root);
		rootChain.Parent = new ParentChain(null);
		
		while (root != null) {
			
			//Visit the node when nothing is visited.
			if(!rootChain.leftVisited && !rootChain.rightVisited) {
				System.out.println(root.data); //Visit the node.
			}
			
			//Going back to parent
			if(rootChain.leftVisited && rootChain.rightVisited) {
				ParentChain parentChain = rootChain.Parent;
				rootChain.Parent = null; //Avoid the leak
				rootChain = parentChain;
				root = rootChain.root;
				continue;
			}
			
			//Traverse Left
			if(!rootChain.leftVisited) {
				rootChain.leftVisited = true;
				if (root.left != null) {
					ParentChain local = new ParentChain(root.left); //It is better to use pool to reuse the instances.
					local.Parent = rootChain;
					rootChain = local;
					root = root.left;
					continue;
				}
			} 
			
			//Traverse RIGHT
			if(!rootChain.rightVisited) {
				rootChain.rightVisited = true;
				if (root.right != null) {
					ParentChain local = new ParentChain(root.right); //It is better to use pool to reuse the instances.
					local.Parent = rootChain;
					rootChain = local;
					root = root.right;
					continue;
				}
			}
		}
	}
}

class ParentChain {
	BTNode<String> root;
	ParentChain Parent;
	boolean leftVisited = false;
	boolean rightVisited = false;
	
	public ParentChain(BTNode<String> node) {
		this.root = node; 
	}
	
	@Override
	public String toString() {
		return root.toString();
	}
}