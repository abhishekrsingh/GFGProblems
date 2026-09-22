/* Structure of binary tree Node
class Node {
	int data;
	Node left, right;
	
	Node(int x) {
		data = x;
		left = right = null;
	}
}
*/

class Solution {
	public boolean areAnagrams(Node root1, Node root2) {
		
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		
		q1.add(root1);
		q2.add(root2);
		
		while (!q1.isEmpty() && !q2.isEmpty()) {
			
			int size1 = q1.size();
			int size2 = q2.size();
			
			// Different number of nodes at this level
			if (size1 != size2) {
				return false;
			}
			
			HashMap<Integer, Integer> map = new HashMap<>();
			
			// Process first tree's current level
			for (int i = 0; i < size1; i++) {
				
				Node curr = q1.poll();
				
				map.put(
				curr.data,
				map.getOrDefault(curr.data, 0) + 1
				);
				
				if (curr.left != null) {
					q1.add(curr.left);
				}
				
				if (curr.right != null) {
					q1.add(curr.right);
				}
			}
			
			// Process second tree's current level
			for (int i = 0; i < size2; i++) {
				
				Node curr = q2.poll();
				
				map.put(
				curr.data,
				map.getOrDefault(curr.data, 0) - 1
				);
				
				if (curr.left != null) {
					q2.add(curr.left);
				}
				
				if (curr.right != null) {
					q2.add(curr.right);
				}
			}
			
			// Check frequency
			for (int freq : map.values()) {
				if (freq != 0) {
					return false;
				}
			}
		}
		
		return q1.isEmpty() && q2.isEmpty();
	}
}
