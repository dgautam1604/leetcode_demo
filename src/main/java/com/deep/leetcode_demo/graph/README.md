DFS is iterative: A stack is created we pop the current source and add its neighbors. 
This process is repeated till no neighbors are left.
```
public static void dfsPrint(Map<String,String[]> l, String src){
        Stack s=new Stack();
        s.push(src);
        while(!s.isEmpty()){
            String temp=(String)s.pop();
            System.out.println(temp);
            for(String i:l.get(temp)){
                s.push(i);
            }
        }
    }
```

BFS is also iterative and used exactly like dfs but with a Queue.

```
public static void bfsPrint(Map<String,String[]> l, String src){
        Queue<String> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            String temp=q.remove();
            System.out.println(temp);
            for(String i:l.get(temp)){
                q.add(i);
            }
        }
    }
```

✅ BFS is naturally iterative 
✅ DFS can be recursive or iterative

Because recursion uses a stack, not a queue — and using recursion would violate the level-order behavior of BFS.

```
public static void dfsPrintRecursive(Map<String,String[]> l, String src){
        System.out.println(src);
        for(String i:l.get(src)){
            dfsPrintRecursive(l,i);
        }
    }
```