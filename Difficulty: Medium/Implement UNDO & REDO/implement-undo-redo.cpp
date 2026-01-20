class Solution {
  public:
    string str="";
    vector<char>v;
    void append(char x) {
        // append x into document
        str.push_back(x);
    }

    void undo() {
        // undo last change
        v.push_back(str[str.size()-1]);
        str.pop_back();
        
    }

    void redo() {
        // redo changes
        if(v.size()==0) return;
        str.push_back(v[v.size()-1]);
        v.pop_back();
    }

    string read() {
        // read the document
        return str;
    }
};