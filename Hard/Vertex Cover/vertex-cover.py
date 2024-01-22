from typing import List


class Solution:
    def vertexCover(self, num_nodes: int, edges: List[List[int]]) -> int:
        # Base case: If there are no nodes, the minimum vertex cover size is 0.
        if num_nodes == 0:
            return 0
           
        # Initialize separate lists for edges connected to two different vertices.
        first_vertex_edges, second_vertex_edges = [], []
       
        # Get the first edge to compare with other edges.
        first_vertex, second_vertex = edges[0]
        count_first_vertex, count_second_vertex = 0, 0
       
        # Iterate through the edges to categorize them based on their vertices.
        for vertex1, vertex2 in edges:
            # Check if the current edge is not connected to the first vertex.
            if not (vertex1 == first_vertex or vertex2 == first_vertex):
                first_vertex_edges.append([vertex1, vertex2])
                count_first_vertex += 1
           
            # Check if the current edge is not connected to the second vertex.
            if not (vertex1 == second_vertex or vertex2 == second_vertex):
                second_vertex_edges.append([vertex1, vertex2])
                count_second_vertex += 1
       
        # Recursively find the minimum vertex cover size for both sets of edges.
        return 1 + min(
            self.vertexCover(count_first_vertex, first_vertex_edges),
            self.vertexCover(count_second_vertex, second_vertex_edges)
        )
        



#{ 
 # Driver Code Starts
class IntMatrix:
    def __init__(self) -> None:
        pass
    def Input(self,n,m):
        matrix=[]
        #matrix input
        for _ in range(n):
            matrix.append([int(i) for i in input().strip().split()])
        return matrix
    def Print(self,arr):
        for i in arr:
            for j in i:
                print(j,end=" ")
            print()


if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        n = int(input())
        
        
        m = int(input())
        
        
        edges=IntMatrix().Input(m, m)
        
        obj = Solution()
        res = obj.vertexCover(n, edges)
        
        print(res)
        

# } Driver Code Ends