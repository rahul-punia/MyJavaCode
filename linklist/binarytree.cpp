// C program for different tree traversals 
#include <iostream> 
#include<queue>
using namespace std; 

/* A binary tree node has data, pointer to left child 
and a pointer to right child */
struct Node 
{ 
	int data; 
	struct Node* left, *right; 
	Node(int data) 
	{ 
		this->data = data; 
		left = right = NULL; 
	} 
}; 

/* Given a binary tree, print its nodes according to the 
"bottom-up" postorder traversal. */
void printPostorder(struct Node* node) 
{ 
	if (node == NULL) 
		return; 

	// first recur on left subtree 
	printPostorder(node->left); 

	// then recur on right subtree 
	printPostorder(node->right); 

	// now deal with the node 
	cout << node->data << " "; 
} 

/* Given a binary tree, print its nodes in inorder*/
void printInorder(struct Node* node) 
{ 
	if (node == NULL) 
		return; 

	/* first recur on left child */
	printInorder(node->left); 

	/* then print the data of node */
	cout << node->data << " "; 

	/* now recur on right child */
	printInorder(node->right); 
} 

/* Given a binary tree, print its nodes in preorder*/
void printPreorder(struct Node* node) 
{ 
	if (node == NULL) 
		return; 

	/* first print data of node */
	cout << node->data << " "; 

	/* then recur on left sutree */
	printPreorder(node->left); 

	/* now recur on right subtree */
	printPreorder(node->right); 
} 

  
/* Function to get the count  
of leaf nodes in a binary tree*/
unsigned int getLeafCount(struct Node* node)  
{  
    if(node == NULL)      
        return 0;  
    if(node->left == NULL && node->right == NULL)  
        return 1;          
    else
        return getLeafCount(node->left)+  
            getLeafCount(node->right);  
}  

int count(struct Node *tree)
{
    int c=1;

    if (tree ==NULL)
        return 0;

    else
    {
        c += count(tree->left);
        c += count(tree->right);
        return c;
    }
}
int treeHeight(struct Node *root) 
{ 
    // Base Case 
    if (root == NULL) 
        return 0; 
  
    // Create an empty queue for level order tarversal 
    queue<Node *> q; 
  
    // Enqueue Root and initialize height 
    q.push(root); 
    int height = 0; 
  
    while (1) 
    { 
        // nodeCount (queue size) indicates number of nodes 
        // at current lelvel. 
        int nodeCount = q.size(); 
        if (nodeCount == 0) 
            return height; 
  
        height++; 
  
        // Dequeue all nodes of current level and Enqueue all 
        // nodes of next level 
        while (nodeCount > 0) 
        { 
            Node *node = q.front(); 
            q.pop(); 
            if (node->left != NULL) 
                q.push(node->left); 
            if (node->right != NULL) 
                q.push(node->right); 
            nodeCount--; 
        } 
    } 
} 


/* Driver program to test above functions*/
int main() 
{ 
	struct Node *root = new Node(1); 
	root->left			 = new Node(2); 
	root->right		 = new Node(3); 
	root->left->left	 = new Node(4); 
	root->left->right = new Node(5); 
     cout<<"output"<<endl;
	cout << "Preorder traversal of binary tree is \n"; 
	printPreorder(root); 

	cout << "\nInorder traversal of binary tree is \n"; 
	printInorder(root); 

	cout << "\nPostorder traversal of binary tree is \n"; 
	printPostorder(root); 
    cout<<endl;
     cout<<"Total no of nodes-"<<count(root)<<endl;
  
      
/*get leaf count of the above created tree*/
cout << "Leaf count of the tree is : "<<  
                getLeafCount(root) << endl;

cout << "Height of tree is " << treeHeight(root)<<endl;   
	return 0; 
} 
