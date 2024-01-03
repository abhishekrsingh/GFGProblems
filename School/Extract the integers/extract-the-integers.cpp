//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
vector<string> extractIntegerWords(string s);

int main()
{
    int t;
    cin>>t;
    cin.ignore();
    while(t--)
    {
        string str;
        getline(cin,str);
        vector<string> ans = extractIntegerWords(str);
        if(ans.size() == 0)
            cout<<"No Integers";
        else
            for(auto i: ans) cout<<i<<' ';
        cout<<endl;
    }
    return 0;
}

// } Driver Code Ends


vector<string> extractIntegerWords(string str)
{
    // code here
    // Vector to store extracted integer words
    std::vector<std::string> result;

    // This variable will store each found integer temporarily
    std::string tillNow = "";

    for (char ch : str) {
        // If current character is a digit, then add it to the string tillNow
        if (isdigit(ch)) {
            tillNow += ch;
        } else {
            // If tillNow is not empty, convert it to integer and add to the result vector
            if (!tillNow.empty()) {
                result.push_back(tillNow);

                // Reset tillNow
                tillNow.clear();
            }
        }
    }

    // If tillNow isn't empty, convert it to integer and add to the result vector
    if (!tillNow.empty()) {
        result.push_back(tillNow);
    }

    return result;
}