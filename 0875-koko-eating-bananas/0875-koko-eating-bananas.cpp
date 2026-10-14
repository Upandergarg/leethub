class Solution {
public:
    bool ispossible(vector<int>& arr, int h, int mid) {
        long int hr = 0;
        for (int pile : arr) {
            hr += (pile + mid - 1) / mid;
        }
        return hr <= h;
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        int imax = INT_MIN;
        for (int i = 0; i < piles.size(); i++) {
            imax = max(imax, piles[i]);
        }

        int st = 1;
        int end = imax;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (ispossible(piles, h, mid)) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return st;  // ✅ safe: final minimum speed
    }
};