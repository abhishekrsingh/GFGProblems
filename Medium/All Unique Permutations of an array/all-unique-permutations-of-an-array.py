class Solution:
    def uniquePerms(self, elements, length):
        def generate_permutations(current_permutation, remaining_length, current_position):
            if remaining_length == 0:
                result.add(tuple(current_permutation[:]))
                return

            for i in range(current_position, len(current_permutation)):
                # Swap elements to explore different permutations
                current_permutation[current_position], current_permutation[i] = current_permutation[i], current_permutation[current_position]
               
                # Recursively generate permutations with the updated state
                generate_permutations(current_permutation, remaining_length - 1, current_position + 1)
               
                # Revert the swap to backtrack and explore other permutations
                current_permutation[current_position], current_permutation[i] = current_permutation[i], current_permutation[current_position]

        # Sort the input list to ensure consistent ordering
        elements.sort()
        result = set()
        generate_permutations(elements, length, 0)
       
        # Convert the set to a sorted list for consistent output
        return sorted(list(result))


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        n=int(input())
        arr=list(map(int,input().split()))
        
        ob = Solution()
        res = ob.uniquePerms(arr,n)
        for i in range(len(res)):
            for j in range(n):
                print(res[i][j],end=" ")
            print()
# } Driver Code Ends