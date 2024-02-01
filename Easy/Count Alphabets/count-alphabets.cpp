//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
int Count(string S);


int main(){
    int t;
    cin >> t;
    while(t--){
        string S;
        cin >> S;
        cout << Count(S) << endl;
    }
return 0;
}


// } Driver Code Ends


    int Count(string str){
        //complete the function here
        int count = 0;
        for(int i = 0; i < str.length(); i++)
        {
            if ('A' <= str[i] && str[i] <= 'Z')
                count++;
            else if ('a' <= str[i] && str[i] <= 'z')
                count++;
            else
                continue;
        }
        return count;
    }
