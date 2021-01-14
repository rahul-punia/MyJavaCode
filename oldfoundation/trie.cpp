#include<iostream>
#include<unordered_map>

using namespace std;
class node
{
    public:
    char data;
    bool end;
    unordered_map<char,node*>children;

};
class trie
{
    private:
    node* root;
    int words;
    int nodes;

    bool search(node* temp,string word,int idx){
        if(idx==word.length()){
            return temp->end;
        }
        char ch=word[idx];
        if(temp->children.count(ch)==0){
            return false;
        }else{
          node* child=temp->children[ch];
          return search(temp->children[ch],word,idx+1);

        }
    }
    void add(node* temp,string word,int idx){
        if(idx==word.length()){
            words++;
            temp->end=true;
            return;
        }

        char ch=word[idx];
        if(temp->children.count(ch)==0){
            nodes++;

            node* child=new node();
            child->data=ch;
            child->end=false;
            temp->children[ch]=child;
            add(child,word,idx+1);
        }else{
            node* child=temp->children[ch];
            add(child,word,idx+1);
        }
    }
    void displayWords(node* temp,string wsf){
        if(temp->end){
            cout<<wsf<<endl;
        }
        for(auto itr=temp->children.begin();itr!=temp->children.end();itr++){
          displayWords(itr->second,wsf+itr->first);
        }
    }
    
    void displayTrie(node* temp){
        cout<<temp->data<<"->";
        for(auto itr=temp->children.begin();itr!=temp->children.end();itr++){
            cout<<itr->first<<",";//itr->second->end?"*":",";
        }
        cout<<"."<<endl;
         for(auto itr=temp->children.begin();itr!=temp->children.end();itr++){
            displayTrie(itr->second);
        }

    }
    void remove(node* temp,string word,int idx){
        if(idx==word.length()){
         words--;
         temp->end=false;
         return;
        }
        char ch=word[idx];
        node* child=temp->children[ch];
        remove(temp->children[ch],word,idx+1);
        if(child->end==false && child->children.size()==0){
            temp->children.erase(ch);
            nodes--;
            delete child;
        }
    }
    public :
    trie(){
        root=new node();
        root->data='$';
        root->end=false;
        words=0;
        nodes=1;
    }
    bool search(string words){
         return search(root,words,0);
           
    }
    void add(string word){
        if(search(word)==false){
            add(root,word,0);
        }
    }
    void displayWords(){
         displayWords(root," ");
    }
    
    void remove(string word){
        remove(root,word,0);//dd
    }
    void displayTrie(){
        displayTrie(root);
    }
};
int main(int argc,char** argv){
    trie t;
    t.add("are");
    t.add("art");
    t.add("an");
    t.add("and");
    t.add("as");
    t.add("ask");
    t.add("see");
    t.add("sea");
    t.add("seen");
      t.displayWords();

    cout<<t.search("artist")<<t.search("se")<<t.search("seen")<<endl;
   t.remove("as");
   t.remove("ask");
   t.displayTrie();
}