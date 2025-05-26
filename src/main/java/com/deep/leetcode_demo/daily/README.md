poll()	Retrieves and removes the head, When Queue is Empty returns null
remove() Retrieves and removes the head, when empty Throws NoSuchElementException
peek() and element() work in the same way as above of returning but does not remove
the element

```
Queue<String> queue = new LinkedList<>();
```

BFS is also iterative and used exactly like dfs but with a Queue.

```
public static void bfsPrint(Map<String,String[]> l, String src){
        Queue<String> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            String temp=q.poll();
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