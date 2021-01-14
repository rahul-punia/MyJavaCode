#include <iostream> 
using namespace std; 
  
struct Node { 
    int key; 
    struct Node *left, *right; 
}; 
  
// A utility function to create a new BST node 
Node* newNode(int item) 
{ 
    Node* temp = new Node; 
    temp->key = item; 
    temp->left = temp->right = NULL; 
    return temp; 
} 
  struct Node* search(struct Node* root, int key) 
{ 
    // Base Cases: root is null or key is present at root 
    if (root == NULL || root->key == key) 
       return root; 
     
    // Key is greater than root's key 
    if (root->key < key) 
       return search(root->right, key); 
  
    // Key is smaller than root's key 
    return search(root->left, key); 
} 
// A utility function to do inorder traversal of BST 
void inorder(Node* root) 
{ 
    if (root != NULL) { 
        inorder(root->left); 
        cout<<root->key<<" "; 
        inorder(root->right); 
    } 
} 
  
/* A utility function to insert a new node with given key in BST */
Node* insert(Node* node, int key) 
{ 
    /* If the tree is empty, return a new node */
    if (node == NULL) 
        return newNode(key); 
  
    /* Otherwise, recur down the tree */
    if (key < node->key) 
        node->left = insert(node->left, key); 
    else
        node->right = insert(node->right, key); 
  
    /* return the (unchanged) node pointer */
    return node; 
} 
  
/* Given a binary search tree and a key, this function deletes the key 
   and returns the new root */
Node* deleteNode(Node* root, int k) 
{ 
    // Base case 
    if (root == NULL) 
        return root; 
  
    // Recursive calls for ancestors of 
    // node to be deleted 
    if (root->key > k) { 
        root->left = deleteNode(root->left, k); 
        return root; 
    } 
    else if (root->key < k) { 
        root->right = deleteNode(root->right, k); 
        return root; 
    } 
  
    // We reach here when root is the node 
    // to be deleted. 
  
    // If one of the children is empty 
    if (root->left == NULL) { 
        Node* temp = root->right; 
        delete root; 
        return temp; 
    } 
    else if (root->right == NULL) { 
        Node* temp = root->left; 
        delete root; 
        return temp; 
    } 
  
    // If both children exist 
    else { 
  
        Node* succParent = root->right; 
          
        // Find successor 
        Node *succ = root->right; 
        while (succ->left != NULL) { 
            succParent = succ; 
            succ = succ->left; 
        } 
  
        // Delete successor.  Since successor 
        // is always left child of its parent 
        // we can safely make successor's right 
        // right child as left of its parent. 
        succParent->left = succ->right; 
  
        // Copy Successor Data to root 
        root->key = succ->key; 
  
        // Delete Successor and return root 
        delete succ;          
        return root; 
    } 
} 
  
// Driver Program to test above functions 
int main() 
{ 
    /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */
    Node* root = NULL; 
    root = insert(root, 50); 
    root = insert(root, 30); 
    root = insert(root, 20); 
    root = insert(root, 40); 
    root = insert(root, 70); 
    root = insert(root, 60); 
    root = insert(root, 80); 
  
    cout<<"Inorder traversal of the given tree \n"; 
    inorder(root); 
  
    cout<<"\nDelete 20\n"; 
    root = deleteNode(root, 20); 
    cout<<"Inorder traversal of the modified tree \n"; 
    inorder(root); 
  
    cout<<"\nDelete 30\n"; 
    root = deleteNode(root, 30); 
    cout<<"Inorder traversal of the modified tree \n"; 
    inorder(root); 
  
    cout<<"\nDelete 50\n"; 
    root = deleteNode(root, 50); 
    cout<<"Inorder traversal of the modified tree \n"; 
    inorder(root);
    cout<<endl; 
    int val=60;
    Node* res=search(root,60);
    if(res->key==val){
        cout<<res->key<<" found in binary search tree"<<endl;
    }else{
       cout<<res->key<<" not found in binary search tree"<<endl;
    }
    return 0; 
} 