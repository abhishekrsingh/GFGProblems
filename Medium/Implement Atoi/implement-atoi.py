#User function template for Python

class Solution:
    def atoi(self,s):
        res = 0
        pos = 0
        sign = None
        
        for i in s:
            if pos==0 and i=="-":
                sign = "-"
            elif i.isdigit():
                res = (res*10)+int(i)
            else:
                return -1
            pos+=1
        
        return res if not sign else -res


#{ 
 # Driver Code Starts
#Initial template for Python

if __name__=='__main__':
    t=int(input())
    for i in range(t):
        string = input().strip();
        ob=Solution()
        print(ob.atoi(string))
# } Driver Code Ends