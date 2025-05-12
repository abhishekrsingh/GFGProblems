//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

// User function Template for C++
class Solution {
  public:
    int mostBooked(int n, vector<vector<int>> &meetings) {
        // code here
        sort(meetings.begin(), meetings.end());

        priority_queue<int, vector<int>, greater<int>> availableRooms;
        for (int i = 0; i < n; ++i) {
            availableRooms.push(i);
        }

        // occupiedRooms: {end time, room number}
        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> occupiedRooms;

        vector<int> meetingCount(n, 0);

        for (int i = 0; i < meetings.size(); ++i) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            while (!occupiedRooms.empty() && occupiedRooms.top().first <= start) {
                int freedRoom = occupiedRooms.top().second;
                occupiedRooms.pop();
                availableRooms.push(freedRoom);
            }

            int roomAssigned;

            if (!availableRooms.empty()) {
                roomAssigned = availableRooms.top();
                availableRooms.pop();
                occupiedRooms.push(make_pair(end, roomAssigned));
            } else {
                pair<long long, int> top = occupiedRooms.top();
                occupiedRooms.pop();
                long long nextFreeTime = top.first;
                int room = top.second;

                int duration = end - start;
                occupiedRooms.push(make_pair(nextFreeTime + duration, room));
                roomAssigned = room;
            }

            meetingCount[roomAssigned]++;
        }

        int maxMeetings = 0, resultRoom = 0;
        for (int i = 0; i < n; ++i) {
            if (meetingCount[i] > maxMeetings) {
                maxMeetings = meetingCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
};


//{ Driver Code Starts.

int main() {
    int t, n, m;
    cin >> t;
    while (t--) {
        cin >> n;
        cin >> m;
        vector<vector<int>> meetings(m, vector<int>(2));
        for (int i = 0; i < m; i++) {
            cin >> meetings[i][0] >> meetings[i][1];
        }
        Solution ob;
        cout << ob.mostBooked(n, meetings) << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends