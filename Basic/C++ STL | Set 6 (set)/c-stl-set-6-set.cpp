//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

void insert(set<int> &s,int x);

void print_contents(set<int> &s);

void erase(set<int> &s,int x);

int find(set<int> &s,int x);

int size(set<int> &s);

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		set<int> s;
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
				print_contents(s);
			}
			if(c=='c')
			{
				int x;
				cin>>x;
				erase(s,x);
			}
			if(c=='d')
			{
				int x;
				cin>>x;
				cout<<find(s,x)<<" ";
			}
                       if(c=='e')
                       cout<<size(s)<<" ";
		
		}
cout<<endl;
	}
	return 0;
}
// } Driver Code Ends


/* You are required to complete below methods */

void insert( set< int >& s, int x ) {
    s.insert( x );
}
void print_contents( set< int >& s ) {
    for ( const int i : s ) cout << i << ' ';
}
void erase( set< int >& s, int x ) {
    s.erase( x );
}
int find( set< int >& s, int x ) {
    return s.find( x ) == s.cend() ? -1 : 1;
}
int size( set< int >& s ) {
    return s.size();
}