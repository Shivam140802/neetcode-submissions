class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size()!=t.size()) return false;
        unordered_map<char, int> mp1;
        unordered_map<char, int> mp2;
        for(char ch: s){
            mp1[ch]++;   
        }
        for(char ch: t){
            mp2[ch]++;
        }
        for(auto &[key, value]: mp1){
            auto it= mp2.find(key);
            if(it==mp2.end() || it->second!=value) return false;
        }
        return true;
    }
};
