//{ Driver Code Starts
// Program to find the maximum profit job sequence from a given array 
// of jobs with deadlines and profits 
#include<bits/stdc++.h>
using namespace std; 

// A structure to represent a job 
struct Job 
{ 
    int id;	 // Job Id 
    int dead; // Deadline of job 
    int profit; // Profit if job is over before or on deadline 
}; 


// } Driver Code Ends
/*
struct Job 
{ 
    int id;	 // Job Id 
    int dead; // Deadline of job 
    int profit; // Profit if job is over before or on deadline 
};
*/

class Solution 
{
    public:
    //Function to find the maximum profit and the number of jobs done.
    static bool comp(Job& j1, Job& j2){
       return j1.dead < j2.dead;
   }
   
   //Function to find the maximum profit and the number of jobs done.
   vector<int> JobScheduling(Job arr[], int n) 
   { 
       sort(arr, arr + n, comp);
   
       vector<int> res(2,0);
       priority_queue<int, vector<int>, greater<int>> pq;
       pq.push(arr[0].profit);
       
       for(int i = 1; i< n; i++){
           if(arr[i].dead > pq.size())
               pq.push(arr[i].profit);
           else{
               if(pq.top() < arr[i].profit){
                   pq.pop();
                   pq.push(arr[i].profit);
               }
           }
       }
       
       res[0] = pq.size();
       while(!pq.empty()){
           res[1] += pq.top();
           pq.pop();
       }
       
       return res;
       
   } 
};

//{ Driver Code Starts.
// Driver program to test methods 
int main() 
{ 
    int t;
    //testcases
    cin >> t;
    
    while(t--){
        int n;
        
        //size of array
        cin >> n;
        Job arr[n];
        
        //adding id, deadline, profit
        for(int i = 0;i<n;i++){
                int x, y, z;
                cin >> x >> y >> z;
                arr[i].id = x;
                arr[i].dead = y;
                arr[i].profit = z;
        }
        Solution ob;
        //function call
        vector<int> ans = ob.JobScheduling(arr, n);
        cout<<ans[0]<<" "<<ans[1]<<endl;
    }
	return 0; 
}



// } Driver Code Ends