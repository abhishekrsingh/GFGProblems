from collections import deque

class Solution:
    def findOrder(self, num_courses, prerequisites_count, prerequisites):
        # Initialize indegree array and adjacency list
        indegree = [0 for course in range(num_courses)]
        adjacency_list = [[] for course in range(num_courses)]

        # Populate indegree array and adjacency list
        for prerequisite in prerequisites:
            course_to_take, prerequisite_for_course = prerequisite
            indegree[course_to_take] += 1
            adjacency_list[prerequisite_for_course].append(course_to_take)

        # Initialize queue, stack, and count
        queue = deque()
        stack = []
        count = 0

        # Add courses with indegree 0 to the queue
        for course in range(num_courses):
            if not indegree[course]:
                queue.append(course)

        # Topological Sort
        while queue:
            current_course = queue.popleft()
            stack.append(current_course)
            count += 1

            # Update indegree for adjacent courses
            for neighbor_course in adjacency_list[current_course]:
                indegree[neighbor_course] -= 1
                if not indegree[neighbor_course]:
                    queue.append(neighbor_course)

        # Check if all courses were taken
        return stack if count == num_courses else []


#{ 
 # Driver Code Starts
# Driver Program

import sys
sys.setrecursionlimit(10**6)
        
def check(graph, N, res):
	map=[0]*N
	for i in range(N):
		map[res[i]]=i
	for i in range(N):
		for v in graph[i]:
			if map[i] > map[v]:
				return False
	return True

if __name__=='__main__':
    t = int(input())
    for i in range(t):
        n,m = list(map(int, input().strip().split()))
        adj = [[] for i in range(n)]
        prerequisites = []
        
        for i in range(m):
            u,v=map(int,input().split())
            adj[v].append(u)
            prerequisites.append([u,v])
            
        ob = Solution()
        
        res = ob.findOrder(n, m, prerequisites)
        
        if(not len(res)):
            print("No Ordering Possible")
        else:
            if check(adj, n, res):
                print(1)
            else:
                print(0)
# } Driver Code Ends