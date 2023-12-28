#User function Template for python3

class Solution:
    def antiDiagonalPattern(self, matrix):
        num_rows, num_cols = len(matrix), len(matrix[0])

        # Dictionary to store elements grouped by their anti-diagonal index
        anti_diagonal_groups = {}

        # Populate anti_diagonal_groups dictionary
        for i in range(num_rows):
            for j in range(num_cols):
                anti_diagonal_index = i + j
                anti_diagonal_groups[anti_diagonal_index] = anti_diagonal_groups.get(anti_diagonal_index, []) + [matrix[i][j]]

        result = []

        # Flatten the anti-diagonal groups into the final result list
        for i in range(num_rows + num_cols - 1):
            result.extend(anti_diagonal_groups[i])

        return result


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input()) 
        inp=list(map(int,input().split()))
        matrix=[]
        k = 0
        for i in range(n):
            row = []
            for j in range(n):
                row.append(inp[k])
                k += 1
            matrix.append(row)
        ob = Solution()
        ans = ob.antiDiagonalPattern(matrix)
        for i in ans:
            print(i,end=" ")
        print()


# } Driver Code Ends