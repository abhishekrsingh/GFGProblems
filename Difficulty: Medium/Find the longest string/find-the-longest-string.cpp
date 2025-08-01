class Solution {
  public:
    struct TrieNode {
        bool      isEndOfWord;
        TrieNode* children[26];

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < 26; i++) {
                children[i] = nullptr;
            }
        }
    };

    TrieNode* root = new TrieNode();

    // Insert a word into the Trie
    void insert(string& word) {
        TrieNode* crawler = root;

        for (char c : word) {
            int index = c - 'a';
            if (crawler->children[index] == nullptr) {
                crawler->children[index] = new TrieNode();
            }
            crawler = crawler->children[index];
        }
        crawler->isEndOfWord = true; // mark end of this word
    }
    
    // Return true if all prefixes of word exist and are ends of words
    bool search(string& word) {
        TrieNode* crawler = root;

        for (char c : word) {
            int index = c - 'a';
            crawler = crawler->children[index];
            if (crawler == nullptr || crawler->isEndOfWord == false) {
                return false; // missing prefix or prefix not a completed word
            }
        }
        return true;
    }

    string longestString(vector<string>& arr) {
        // build Trie
        for (string& word : arr) {
            insert(word);
        }

        string result = "";
        // check each word
        for (string& word : arr) {
            if (search(word)) {
                // choose longer or lexicographically smaller on tie
                if (word.length() > result.length() ||
                    (word.length() == result.length() && word < result)) {
                    result = word;
                }
            }
        }
        return result;
    }
};