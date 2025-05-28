class Solution {
  public:
    bool ValidCorner(vector<vector<int>>& mat) {
        int r = mat.size();         // number of rows
        int c = mat[0].size();      // number of columns

        unordered_set<string> st;   // to store seen column pairs

        for (int i = 0; i < r; i++) {
            vector<int> cols;       // store column indices where row i has 1

            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {
                    cols.push_back(j);
                }
            }

            // check all pairs of 1s in current row
            for (int x = 0; x < cols.size(); x++) {
                for (int y = x + 1; y < cols.size(); y++) {
                    string valid_pair = to_string(cols[x]) + "_" + to_string(cols[y]);

                    // if this pair already exists in some previous row → rectangle found
                    if (st.count(valid_pair)) {
                        return true;
                    }

                    // insert this pair for the current row
                    st.insert(valid_pair);
                }
            }
        }

        return false;  // no rectangle with 1s found
    }
};