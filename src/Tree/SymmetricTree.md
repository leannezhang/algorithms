# Symmetric Tree

> Given a binary tree, check whether it is a mirror of itself(ie, symmetric around its center)

> For example, this tree is symmetric:


```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```
> But the following tree is not.

```
    1
   / \
  2   2
   \   \
   3    3
```

#### Solve it recursively.

- Identify the base case. What is the false case? What's the true case?
- Generic case: Assume that the recursive function works, how can I solve the subsets using the recursion method I created?


![Image of Symmetric Tree][Symmetric1]
[Symmetric1]: https://github.com/leannezhang/algorithms/blob/master/src/Tree/images/SymmetricTree.png "Recursive"

```java

    public boolean isSymmetric(TreeNode root) {
        if (root != null) {
            return isMirror(root.left, root.right);
        }
        return true;
    }

    public boolean isMirror(TreeNode subtree1, TreeNode subtree2) {
        // base case: true case
        if(subtree1 == null && subtree2 == null) {
            return true;
        }
        // base case: false case
        if (subtree1 !=null && subtree2 == null || subtree2 != null && subtree1 == null) {
            return false;
        }
       // generic case: solve the subcases using the recursive call
       return (subtree1.val == subtree2.val) &&
              (isMirror(subtree1.left, subtree2.right)) &&
              (isMirror(subtree1.right, subtree2.left));
    }
```
Run Time: Since we are visiting every node in the tree, it would be O(n) time.

Space Complexity: Each recursive call is put on to a recursive stack so it's determined by the tree height.
In the worse case, the tree is linear and the height is in O(n). So space complexity is O(n).

#### Solve it iteratively.

Symmetrical means traversing the tree layer by layer from left to right or from right to left should give you the same results.
When one layer is symmetrical, we can continue look at the next layer.
Thus, the pattern we see is Breadth First Search. (searching layer by layer and using a Queue)

We insert two nodes to the queue at a time.
 - add the node on left first for T1
 - add the node on the right for T2

When we remove them, we compare if they have the same values. Continue doing this until you find a non-symmetrical match.

```java
    public boolean isSymmetric(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<TreeNode>();
       q.add(root);
       q.add(root);
       while (!q.isEmpty()) {
           TreeNode t1 = q.poll();
           TreeNode t2 = q.poll();

           if (t1 == null && t2 == null) {
               continue;
           }
           if (t1 == null && t2 !=null || t2 == null && t1!=null) {
               return false;
           }
           if (t1.val != t2.val) {
               return false;
           }
           q.add(t1.left);
           q.add(t2.right);
           q.add(t1.right);
           q.add(t2.left);
       }
       return true;
    }

```

Run time: O(n) because we are visiting every node.
Space Complexity: O(n) because we store every node on the queue.