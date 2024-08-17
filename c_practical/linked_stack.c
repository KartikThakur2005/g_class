#include<stdio.h>
#include<assert.h>
#include<stdlib.h>
#include<limits.h>


struct Node{
        int item;
        struct Node* next;


}
typedef struct Node Node;
Node* head = NULL;
int N = 0;

void push(int item){
        node* oldhead = head;
        head = (Node *) malloc(sizeof(Node));
        head->item = item;
        head->next = oldhead;
        N++;
}

int  pop(){
        if(N==0) return INT_MIN;
        int item  = head->item;
        Node* temp = head;
        head = head->next;
        N--;
        free(temp);
}
int size(){
        return N;
}
bool isEmpty(){
        if(N==0)return true;
        return false;
}

int test_stack(){
        push(3);
        push(4);
        push(5);
        assert(size()==3);
        assert(pop()==5);


}

int main(){
        test_stack();
        return 0;
}
                                      
