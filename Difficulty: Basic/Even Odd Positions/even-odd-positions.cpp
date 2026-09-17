class Solution {
  public:
    long long int totalFine(int date, vector<int> &car, vector<int> &fine) {
        // code here
        if(car.size() != fine.size()) return 0;
        int totalFine = 0;
        bool dateIsEven = (date % 2 == 0);
        for(int i=0; i<car.size(); i++){
            int carIsEven = (car[i] % 2 == 0);
            if(dateIsEven && !carIsEven) totalFine += fine[i];
            else if(!dateIsEven && carIsEven) totalFine += fine[i];
        }
        return totalFine;
    }
};