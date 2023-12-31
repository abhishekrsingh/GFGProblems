//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

void insert(unordered_set<int> &s,int x);

void erase(unordered_set<int> &s,int x);
int size(unordered_set<int> &s);
int find(unordered_set<int> &s,int x);


int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		unordered_set<int> s;
		int q;
		cin>>q;
		while(q--)
		{
			char c;
			cin>>c;
			if(c=='a')
			{
				int x;
				cin>>x;
				insert(s,x);
			}
		
			if(c=='b')
			{
				int x;
				cin>>x;
				erase(s,x);
			}
			if(c=='c')
			{
				int x;
				cin>>x;
				cout<<find(s,x)<<" ";
			}if(c=='d')
                       cout<<size(s)<<" ";
		
		}
cout<<endl;
	}
	return 0;
}
// } Driver Code Ends


/* You are required to complete below methods */

void insert( unordered_set< int >& s, int x ) {
    s.insert( x );
}
void erase( unordered_set< int >& s, int x ) {
    s.erase( x );
}
int size( unordered_set< int >& s ) {
    return s.size();
}
int find( unordered_set< int >& s, int x ) {
    return s.find( x ) == s.cend() ? -1 : 1;
}
