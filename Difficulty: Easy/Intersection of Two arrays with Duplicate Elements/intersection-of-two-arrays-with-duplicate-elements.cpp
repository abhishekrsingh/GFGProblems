class Solution {
  public:
    vector<int> intersect(vector<int>& a, vector<int>& b) {
        // code here
        int n = a.size();
        int m = b.size();
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        set<int> st;
        int i=0, j=0;
        while(i<n && j<m)
        {
            if(a[i] == b[j])
            {
                st.insert(a[i]);
                i++; j++;
            }else if(a[i] < b[j]){
                i++;
            }else{
                j++;
            }
        }
        vector<int> result(st.begin(), st.end());
        return result;
    }
    // vector<int> intersect(vector<int>& a, vector<int>& b) {
    //     // code here
    //     int n = a.size();
    //     int m = b.size();
    //     vector<int> storeA(a.begin(), a.end());
    //     set<int> result;
    //     for(int i=0; i<m; i++)
    //     {
    //         auto it = find(storeA.begin(), storeA.end(), b[i]);

    //         if (it != storeA.end()) {
    //             result.insert(b[i]);
    //         } 
    //     }
    //     `vector<int> finalresult(result.begin(), result.end());
    //     return finalresult;
    // }
};